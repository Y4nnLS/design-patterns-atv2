
package Q4_chain;

public class ValidadorRegrasFiscais implements Validator {
    public String nome(){ return "Regras Fiscais"; }
    public ValidationResult validate(NFe doc) throws Exception {
        // Executa apenas se anteriores passaram (controlado na chain)
        // Dummy: falha se numero termina com '9'
        if (doc.numero != null && doc.numero.endsWith("9")) {
            return ValidationResult.fail("Cálculo de imposto inconsistente (dummy).");
        }
        return ValidationResult.ok();
    }
}
