
package Q1_strategy;

public class StressTestingStrategy implements RiskAlgorithm {
    public String nome() { return "StressTesting"; }
    public String calcular(RiskContext ctx) {
        return "[StressTest] Choques severos aplicados (cenários FX/juros). Capital=" + ctx.capital;
    }
}
