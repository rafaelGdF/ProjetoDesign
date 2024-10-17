public class ProdutoFactory {
    public static Produto criarProduto(String tipo, String nome, double preco, Categoria categoria) {
        if (tipo.equalsIgnoreCase("eletronico")) {
            return new Eletronico(nome, preco, categoria);
        } else if (tipo.equalsIgnoreCase("roupa")) {
            return new Roupas(nome, preco, categoria);
        }
        // Adicionar outros tipos de produtos conforme necessário
        return null;
    }
}