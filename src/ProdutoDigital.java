public class ProdutoDigital extends Produto {
    private double tamanhoArquivoMB;

    public ProdutoDigital(String nome, double preco, Categoria categoria, double tamanhoArquivoMB) {
        super(nome, preco, categoria);
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Produto Digital: " + nome + " - Preço: " + preco + " - Categoria: " + categoria.getNome() + " - Tamanho do Arquivo: " + tamanhoArquivoMB + "MB");
    }
}
