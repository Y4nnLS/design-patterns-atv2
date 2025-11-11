
package Q2_adapter;

public class Resposta {
    public final boolean aprovado;
    public final String codigoAutorizacao;
    public final String mensagem;

    public Resposta(boolean aprovado, String codigoAutorizacao, String mensagem) {
        this.aprovado = aprovado;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
    }

    @Override public String toString() {
        return "Resposta{aprovado=" + aprovado + ", cod=" + codigoAutorizacao + ", msg='" + mensagem + "'}";
    }
}
