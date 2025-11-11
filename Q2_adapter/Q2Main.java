
package Q2_adapter;

import java.util.HashMap;

public class Q2Main {
    public static void main(String[] args) {
        SistemaBancarioLegado legado = new SistemaBancarioLegadoImpl();

        ProcessadorTransacoes proc = new ModernToLegacyAdapter(legado, "MOBILE_APP");
        System.out.println(proc.autorizar("411111******1111", 250.00, "BRL"));
        System.out.println(proc.autorizar("411111******1111", 1500.00, "USD"));

        ProcessadorTransacoes modernoFake = (cartao, valor, moeda) ->
                new Resposta(valor <= 500, java.util.UUID.randomUUID().toString().substring(0,8),
                        valor <= 500 ? "OK modern" : "Limite moderno");
        SistemaBancarioLegado legToModern = new LegacyToModernAdapter(modernoFake);

        HashMap<String,Object> req = new HashMap<>();
        req.put("cartao","5555********4444");
        req.put("valor", 300);
        req.put("moeda", 2); // EUR
        System.out.println(legToModern.processarTransacao(req));
    }
}
