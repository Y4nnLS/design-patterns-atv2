
package Q1_strategy;

public class ValueAtRiskStrategy implements RiskAlgorithm {
    public String nome() { return "ValueAtRisk"; }
    public String calcular(RiskContext ctx) {
        return "[VaR@" + ctx.nivelConfianca + "] Simulado com " + ctx.retornos.length + " retornos. Capital=" + ctx.capital;
    }
}
