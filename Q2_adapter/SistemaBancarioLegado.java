
package Q2_adapter;

import java.util.HashMap;
import java.util.Map;

public interface SistemaBancarioLegado {
    Map<String, Object> processarTransacao(HashMap<String, Object> parametros);
}
