import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Observador> observadores = new ArrayList<>();
    private String status;
    private List<Produto> produtos;
    private double total;

    public Pedido(List<Produto> produtos) {
        this.produtos = produtos;
        calcularTotal();
    }

    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    public void setStatus(String status) {
        this.status = status;
        notificarTodos();
    }

    private void notificarTodos() {
        for (Observador o : observadores) {
            o.atualizar(status);
        }
    }

    private void calcularTotal() {
        total = produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    @Override
    public String toString() {
        return "Pedido com valor total: " + total + " - Status: " + status;
    }
}
