
package Q2_adapter;

import java.util.*;

public class SistemaBancarioLegadoImpl implements SistemaBancarioLegado {
    @Override public Map<String, Object> processarTransacao(HashMap<String, Object> p) {
        Map<String,Object> resp = new HashMap<>();
        if (!p.containsKey("canal")) {
            resp.put("status", "ERRO");
            resp.put("mensagem", "Campo obrigatório ausente: canal");
            return resp;
        }
        boolean ok = ((Number)p.getOrDefault("valor",0)).doubleValue() <= 1000.0;
        resp.put("status", ok ? "APROVADO" : "NEGADO");
        resp.put("codAut", ok ? UUID.randomUUID().toString().substring(0,8) : null);
        resp.put("mensagem", ok ? "OK" : "Acima do limite");
        resp.put("moeda", p.get("moeda")); // código numérico
        return resp;
    }
}
