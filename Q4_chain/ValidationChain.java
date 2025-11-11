
package Q4_chain;

import java.util.*;
import java.util.concurrent.*;

public class ValidationChain {
    private final List<Validator> chain = new ArrayList<>();
    private final Deque<Validator> reversiblesApplied = new ArrayDeque<>();
    private int failCount = 0;

    public ValidationChain add(Validator v){ chain.add(v); return this; }

    public List<ValidationResult> run(NFe doc) {
        List<ValidationResult> out = new ArrayList<>();
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            for (int i=0; i<chain.size(); i++) {
                Validator v = chain.get(i);

                // Condicionais: 3 (i==2) e 5 (i==4) só se anteriores passarem
                if ((i==2 || i==4) && failCount>0) {
                    out.add(new ValidationResult(true, "[SKIP] " + v.nome() + " (falhas anteriores)"));
                    continue;
                }

                // Circuit breaker: após 3 falhas, interrompe
                if (failCount >= 3) {
                    out.add(new ValidationResult(false, "[CB] Circuit breaker acionado. Interrompendo cadeia."));
                    break;
                }

                Future<ValidationResult> fut = es.submit(() -> v.validate(doc));
                ValidationResult r;
                try {
                    r = fut.get(v.timeoutMillis(), TimeUnit.MILLISECONDS);
                } catch (TimeoutException te) {
                    r = ValidationResult.fail("Timeout em " + v.nome());
                } catch (Exception ex) {
                    r = ValidationResult.fail("Exceção em " + v.nome() + ": " + ex.getMessage());
                }

                out.add(r);
                if (!r.ok) {
                    failCount++;
                } else if (v.isReversible()) {
                    reversiblesApplied.push(v);
                }
            }

            // Se houve falha após algum reversível ter sido aplicado, faz rollback LIFO
            if (failCount > 0 && !reversiblesApplied.isEmpty()) {
                while(!reversiblesApplied.isEmpty()){
                    Validator rv = reversiblesApplied.pop();
                    try { rv.rollback(doc); } catch (Exception ignore){}
                }
                out.add(new ValidationResult(true, "[ROLLBACK] Efeitos revertidos após falhas posteriores."));
            }

        } finally {
            es.shutdownNow();
        }
        return out;
    }
}
