public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de " + valor + " realizado via Cartão de Crédito.");
    }
}