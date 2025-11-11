
package Q2_adapter;

import java.util.Locale;

public final class MoedaMapper {
    private MoedaMapper(){}
    public static int isoToLegacyCode(String iso){
        return switch (iso.toUpperCase(Locale.ROOT)) {
            case "USD" -> 1; case "EUR" -> 2; case "BRL" -> 3;
            default -> throw new IllegalArgumentException("Moeda não suportada: " + iso);
        };
    }
    public static String legacyCodeToIso(int code){
        return switch (code) {
            case 1 -> "USD"; case 2 -> "EUR"; case 3 -> "BRL";
            default -> "UNK";
        };
    }
}
