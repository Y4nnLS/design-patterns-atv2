
package Q2_adapter;

import java.util.*;

public class LegacyToModernAdapter implements SistemaBancarioLegado {
    private final ProcessadorTransacoes moderno;

    public LegacyToModernAdapter(ProcessadorTransacoes moderno) {
        this.moderno = moderno;
    }

    @Override
    public Map<String, Object> processarTransacao(HashMap<String, Object> p) {
        String cartao = (String) p.get("cartao");
        double valor = ((Number)p.getOrDefault("valor",0)).doubleValue();
        int moedaCode = ((Number)p.getOrDefault("moeda", 0)).intValue();
        String moedaIso = MoedaMapper.legacyCodeToIso(moedaCode);

        Resposta resp = moderno.autorizar(cartao, valor, moedaIso);
        Map<String,Object> out = new HashMap<>();
        out.put("status", resp.aprovado ? "APROVADO" : "NEGADO");
        out.put("codAut", resp.codigoAutorizacao);
        out.put("mensagem", resp.mensagem);
        out.put("moedaISO", moedaIso);
        return out;
    }
}
