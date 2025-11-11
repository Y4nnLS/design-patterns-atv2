
package Q3_state;

public class Telemetria {
    public double temperaturaC;
    public double pressao;
    public double radiacao;
    public boolean falhaResfriamento;

    public Telemetria(double t, double p, double r, boolean falha) {
        this.temperaturaC = t; this.pressao = p; this.radiacao = r; this.falhaResfriamento = falha;
    }
}
