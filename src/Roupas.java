public class Roupas extends Produto {
    public Roupas(String nome, double preco, Categoria categoria) {
        super(nome, preco, categoria);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Roupas: " + nome + " - Preço: " + preco + " - Categoria: " + categoria.getNome());
    }
}