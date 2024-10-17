public class Pagamento {
    private MetodoPagamento metodo;

    public Pagamento(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void realizarPagamento(double valor) {
        metodo.pagar(valor);
    }
}