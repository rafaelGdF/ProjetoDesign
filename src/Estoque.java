//Singleton

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private static Estoque instance;
    private Map<Produto, Integer> produtosEmEstoque;

    private Estoque() {
        produtosEmEstoque = new HashMap<>();
    }

    public static synchronized Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtosEmEstoque.put(produto, quantidade);
    }

    public int verificarEstoque(Produto produto) {
        return produtosEmEstoque.getOrDefault(produto, 0);
    }

    public void removerProduto(Produto produto, int quantidade) {
        if (produtosEmEstoque.containsKey(produto)) {
            int novaQuantidade = produtosEmEstoque.get(produto) - quantidade;
            if (novaQuantidade <= 0) {
                produtosEmEstoque.remove(produto);
            } else {
                produtosEmEstoque.put(produto, novaQuantidade);
            }
        }
    }
}