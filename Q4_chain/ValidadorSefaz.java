
package Q4_chain;

public class ValidadorSefaz implements Validator {
    public String nome(){ return "Serviço SEFAZ"; }
    public long timeoutMillis(){ return 1500; } // ex: 1.5s

    public ValidationResult validate(NFe doc) throws Exception {
        // Executa apenas se anteriores passaram (controlado na chain)
        // Dummy: se meta "sefazOffline=true", simula timeout/falha longa via sleep
        if (Boolean.TRUE.equals(doc.meta.get("sefazOffline"))) {
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
            return ValidationResult.ok(); // nunca deve chegar aqui por timeout na chain
        }
        // caso normal
        return ValidationResult.ok();
    }
}
