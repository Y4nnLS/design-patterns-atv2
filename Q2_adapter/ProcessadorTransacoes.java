
package Q2_adapter;

public interface ProcessadorTransacoes {
    Resposta autorizar(String cartao, double valor, String moedaISO);
}
