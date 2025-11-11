
package Q1_strategy;

public class RiskContext {
    public final double[] retornos;
    public final double nivelConfianca;
    public final double capital;

    public RiskContext(double[] retornos, double nivelConfianca, double capital) {
        this.retornos = retornos;
        this.nivelConfianca = nivelConfianca;
        this.capital = capital;
    }
}
