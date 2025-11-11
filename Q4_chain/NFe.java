
package Q4_chain;

import java.util.HashMap;
import java.util.Map;

public class NFe {
    public String xml;
    public String numero;
    public boolean inseridoNoBanco = false;
    public Map<String,Object> meta = new HashMap<>();
    public NFe(String xml, String numero){ this.xml=xml; this.numero=numero; }
}
