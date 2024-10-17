import java.util.HashMap;
import java.util.Map;

public class GerenciadorCupons {
    private Map<String, CupomDesconto> cuponsValidos;

    public GerenciadorCupons() {
        cuponsValidos = new HashMap<>();
        // Adiciona cupons válidos
        cuponsValidos.put("DESCONTO10", new CupomDesconto("DESCONTO10", 10));
        cuponsValidos.put("DESCONTO20", new CupomDesconto("DESCONTO20", 20));
    }

    public CupomDesconto verificarCupom(String codigo) {
        return cuponsValidos.getOrDefault(codigo, null);
    }
}