import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observador {
    private String nome;
    private String email;
    private List<Pedido> historicoPedidos;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.historicoPedidos = new ArrayList<>();
    }

    @Override
    public void atualizar(String status) {
        System.out.println("Cliente " + nome + " notificado: Pedido " + status);
    }

    public void adicionarPedidoAoHistorico(Pedido pedido) {
        historicoPedidos.add(pedido);
    }

    public void exibirHistorico() {
        System.out.println("Histórico de Pedidos do Cliente " + nome + ":");
        for (Pedido pedido : historicoPedidos) {
            System.out.println(pedido);
        }
    }

    public String getEmail() {
        return email;
    }
}