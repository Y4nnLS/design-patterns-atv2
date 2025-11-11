
package Q4_chain;

public class ValidationResult {
    public final boolean ok; public final String msg;
    public ValidationResult(boolean ok, String msg){ this.ok=ok; this.msg=msg; }
    public static ValidationResult ok(){ return new ValidationResult(true,"OK"); }
    public static ValidationResult fail(String m){ return new ValidationResult(false,m); }
    public String toString(){return (ok? "OK":"FAIL") + ": " + msg;}
}
