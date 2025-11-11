
package Q3_state;

import java.time.*;

public class UsinaController {
    private Estado estado = Estado.DESLIGADA;
    private boolean manutencao = false;
    private Instant acima400Desde = null;
    private boolean passouPorVermelho = false;

    public Estado getEstado() { return estado; }

    public void setModoManutencao(boolean on){
        this.manutencao = on;
        if (on) System.out.println("[MANUTENÇÃO] Modo ativado.");
        else System.out.println("[MANUTENÇÃO] Modo desativado.");
    }

    private boolean podeIrPara(Estado destino, Telemetria t) {
        if (manutencao && destino != Estado.EMERGENCIA) return true;

        switch (estado) {
            case OPERACAO_NORMAL:
                if (destino == Estado.ALERTA_AMARELO) return t.temperaturaC > 300.0;
                break;
            case ALERTA_AMARELO:
                if (destino == Estado.OPERACAO_NORMAL) return t.temperaturaC <= 300.0;
                if (destino == Estado.ALERTA_VERMELHO) {
                    if (t.temperaturaC > 400.0) {
                        if (acima400Desde == null) acima400Desde = Instant.now();
                        return Duration.between(acima400Desde, Instant.now()).getSeconds() > 30;
                    } else { acima400Desde = null; return false; }
                }
                break;
            case ALERTA_VERMELHO:
                if (destino == Estado.ALERTA_AMARELO) return t.temperaturaC <= 400.0;
                if (destino == Estado.EMERGENCIA) return t.falhaResfriamento;
                break;
            case EMERGENCIA:
                return destino == Estado.DESLIGADA;
            case DESLIGADA:
                // ligar por manutenção / boot controlado
                if (destino == Estado.OPERACAO_NORMAL) return true;
                break;
        }
        if (destino == Estado.EMERGENCIA) {
            return passouPorVermelho && estado == Estado.ALERTA_VERMELHO && t.falhaResfriamento;
        }
        return false;
    }

    public boolean transicionar(Estado destino, Telemetria t) {
        if (destino == Estado.EMERGENCIA && !passouPorVermelho) return false;

        boolean ok = podeIrPara(destino, t);
        if (!ok) return false;

        if (destino == Estado.ALERTA_VERMELHO) passouPorVermelho = true;
        if (destino == Estado.DESLIGADA) {
            acima400Desde = null;
            passouPorVermelho = false;
        }
        this.estado = destino;
        System.out.println("Transição OK -> " + destino);
        return true;
    }
}
