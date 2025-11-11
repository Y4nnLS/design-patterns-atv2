
package Q2_adapter;

import java.util.*;

public class ModernToLegacyAdapter implements ProcessadorTransacoes {
    private final SistemaBancarioLegado legado;
    private final String canalObrigatorio;

    public ModernToLegacyAdapter(SistemaBancarioLegado legado, String canalObrigatorio) {
        this.legado = legado;
        this.canalObrigatorio = canalObrigatorio;
    }

    @Override
    public Resposta autorizar(String cartao, double valor, String moedaISO) {
        HashMap<String,Object> p = new HashMap<>();
        p.put("cartao", cartao);
        p.put("valor", valor);
        p.put("moeda", MoedaMapper.isoToLegacyCode(moedaISO));
        p.put("canal", canalObrigatorio);
        p.put("timestamp", System.currentTimeMillis());

        Map<String,Object> r = legado.processarTransacao(p);
        String status = String.valueOf(r.getOrDefault("status","ERRO"));
        boolean aprovado = "APROVADO".equals(status);
        String cod = (String) r.get("codAut");
        String msg = String.valueOf(r.getOrDefault("mensagem",""));
        return new Resposta(aprovado, cod, msg);
    }
}
