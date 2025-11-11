
package Q1_strategy;

public class RiskCalculator {
    private RiskAlgorithm algoritmo;

    public RiskCalculator(RiskAlgorithm algoritmo) { this.algoritmo = algoritmo; }
    public void setAlgoritmo(RiskAlgorithm novo) { this.algoritmo = novo; }
    public String executar(RiskContext ctx) {
        if (algoritmo == null) throw new IllegalStateException("Algoritmo não definido");
        return algoritmo.calcular(ctx);
    }
}
