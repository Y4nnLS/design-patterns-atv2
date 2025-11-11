
package Q4_chain;

public class ValidadorSchema implements Validator {
    public String nome(){ return "Schema XML"; }
    public ValidationResult validate(NFe doc) {
        boolean ok = doc.xml != null && doc.xml.trim().startsWith("<NFe");
        return ok ? ValidationResult.ok() : ValidationResult.fail("XML inválido contra XSD (dummy).");
    }
}
