import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens;
    private double total;

    public CarrinhoDeCompras() {
        itens = new ArrayList<>();
        total = 0;
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
        total += produto.getPreco();
    }

    public void removerProduto(Produto produto) {
        if (itens.remove(produto)) {
            total -= produto.getPreco();
        }
    }

    public void aplicarCupom(CupomDesconto cupom) {
        total = cupom.aplicarDesconto(total);
    }

    public double getTotal() {
        return total;
    }

    public void finalizarCompra(Cliente cliente, MetodoPagamento metodoPagamento) {
        Pedido pedido = new Pedido(itens);
        cliente.adicionarPedidoAoHistorico(pedido);

        Pagamento pagamento = new Pagamento(metodoPagamento);
        pagamento.realizarPagamento(total);

        pedido.setStatus("Finalizado");
    }
}