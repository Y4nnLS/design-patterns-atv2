
package Q3_state;

public class Q3Main {
    public static void main(String[] args) throws Exception {
        UsinaController uc = new UsinaController();
        System.out.println("Estado inicial: " + uc.getEstado());

        uc.setModoManutencao(true);
        uc.transicionar(Estado.OPERACAO_NORMAL, new Telemetria(290, 1, 1, false));
        uc.setModoManutencao(false);

        uc.transicionar(Estado.ALERTA_AMARELO, new Telemetria(320, 1, 1, false));

        Telemetria t = new Telemetria(405, 1, 1, false);
        Thread.sleep(31000);
        uc.transicionar(Estado.ALERTA_VERMELHO, t);

        uc.transicionar(Estado.EMERGENCIA, new Telemetria(410, 1, 1, true));

        uc.transicionar(Estado.DESLIGADA, new Telemetria(100, 1, 1, false));
    }
}
