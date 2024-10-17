public class Eletronico extends Produto {
    public Eletronico(String nome, double preco, Categoria categoria) {
        super(nome, preco, categoria);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Eletrônico: " + nome + " - Preço: " + preco + " - Categoria: " + categoria.getNome());
    }
}