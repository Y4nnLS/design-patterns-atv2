
package Q4_chain;

import java.util.List;

public class Q4Main {
    public static void main(String[] args) {
        NFe doc = new NFe("<NFe>...</NFe>", "123456");
        // flags de teste:
        //doc.meta.put("certExpirado", true);
        //doc.meta.put("duplicado", true);
        //doc.meta.put("sefazOffline", true);

        ValidationChain chain = new ValidationChain()
                .add(new ValidadorSchema())         // 1
                .add(new ValidadorCertificado())    // 2
                .add(new ValidadorRegrasFiscais())  // 3 (só se anteriores ok)
                .add(new ValidadorBancoDados())     // 4 (reversível)
                .add(new ValidadorSefaz());         // 5 (só se anteriores ok)

        List<ValidationResult> results = chain.run(doc);
        results.forEach(r -> System.out.println(r));

        System.out.println("Inserido no banco? " + doc.inseridoNoBanco);
    }
}
