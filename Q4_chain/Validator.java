
package Q4_chain;

public interface Validator {
    String nome();
    ValidationResult validate(NFe doc) throws Exception;
    default long timeoutMillis(){ return 2000; }
    default boolean isReversible(){ return false; }
    default void rollback(NFe doc){ /* no-op */ }
}
