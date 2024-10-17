import java.util.HashMap;
import java.util.Map;

public class CupomDesconto {
    private String codigo;
    private double percentualDesconto;

    public CupomDesconto(String codigo, double percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public double aplicarDesconto(double valorTotal) {
        return valorTotal - (valorTotal * (percentualDesconto / 100));
    }
}