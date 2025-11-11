
package Q1_strategy;

public class Q1Main {
    public static void main(String[] args) {
        RiskContext ctx = new RiskContext(new double[]{0.01,-0.02,0.015,-0.03}, 0.95, 1_000_000);

        RiskCalculator calc = new RiskCalculator(new ValueAtRiskStrategy());
        System.out.println(calc.executar(ctx));

        calc.setAlgoritmo(new ExpectedShortfallStrategy());
        System.out.println(calc.executar(ctx));

        calc.setAlgoritmo(new StressTestingStrategy());
        System.out.println(calc.executar(ctx));
    }
}
