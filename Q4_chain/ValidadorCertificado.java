
package Q4_chain;

public class ValidadorCertificado implements Validator {
    public String nome(){ return "Certificado Digital"; }
    public ValidationResult validate(NFe doc) throws Exception {
        // Dummy: falha se meta tiver "certExpirado=true"
        boolean exp = Boolean.TRUE.equals(doc.meta.get("certExpirado"));
        boolean rev = Boolean.TRUE.equals(doc.meta.get("certRevogado"));
        if (exp) return ValidationResult.fail("Certificado expirado.");
        if (rev) return ValidationResult.fail("Certificado revogado.");
        return ValidationResult.ok();
    }
}
