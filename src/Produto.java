//Factory

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public abstract void exibirDetalhes();

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }
}