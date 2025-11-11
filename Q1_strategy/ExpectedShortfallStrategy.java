
package Q1_strategy;

public class ExpectedShortfallStrategy implements RiskAlgorithm {
    public String nome() { return "ExpectedShortfall"; }
    public String calcular(RiskContext ctx) {
        return "[ES@" + ctx.nivelConfianca + "] Esperado além do VaR. Capital=" + ctx.capital;
    }
}
