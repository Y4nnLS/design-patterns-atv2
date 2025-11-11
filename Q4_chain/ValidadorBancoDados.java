
package Q4_chain;

public class ValidadorBancoDados implements Validator {
    public String nome(){ return "Banco de Dados"; }
    public boolean isReversible(){ return true; }

    public ValidationResult validate(NFe doc) throws Exception {
        // Dummy duplicidade: se meta 'duplicado=true', falha; caso contrário "insere"
        if (Boolean.TRUE.equals(doc.meta.get("duplicado"))) {
            return ValidationResult.fail("Número de NF-e duplicado.");
        }
        // "Inserir" (side-effect)
        doc.inseridoNoBanco = true;
        return ValidationResult.ok();
    }

    public void rollback(NFe doc){
        if (doc.inseridoNoBanco) {
            doc.inseridoNoBanco = false; // desfaz a "inserção"
            System.out.println("[ROLLBACK] Removendo NF-e do banco (dummy).");
        }
    }
}
