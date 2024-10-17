import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar categorias
        Categoria eletronicos = new Categoria("Eletrônicos", "Dispositivos eletrônicos e acessórios");
        Categoria roupas = new Categoria("Roupas", "Moda e vestuário");

        // Criar produtos
        Produto smartphone = ProdutoFactory.criarProduto("eletronico", "Smartphone XYZ", 1500.00, eletronicos);
        Produto camiseta = ProdutoFactory.criarProduto("roupa", "Camiseta Branca", 50.00, roupas);
        ProdutoDigital ebook = new ProdutoDigital("E-book de Programação", 30.00, eletronicos, 5.5);

        // Criar carrinho e cliente
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");

        // Loop de interação
        while (true) {
            System.out.println("\n===== Bem-vindo ao E-commerce =====");
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Ver carrinho e total");
            System.out.println("3. Aplicar cupom de desconto");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nEscolha um produto para adicionar:");
                    System.out.println("1. " + smartphone.nome + " - R$ " + smartphone.preco);
                    System.out.println("2. " + camiseta.nome + " - R$ " + camiseta.preco);
                    System.out.println("3. " + ebook.nome + " - R$ " + ebook.preco);
                    int produtoEscolhido = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    if (produtoEscolhido == 1) {
                        carrinho.adicionarProduto(smartphone);
                        System.out.println(smartphone.nome + " adicionado ao carrinho.");
                    } else if (produtoEscolhido == 2) {
                        carrinho.adicionarProduto(camiseta);
                        System.out.println(camiseta.nome + " adicionado ao carrinho.");
                    } else if (produtoEscolhido == 3) {
                        carrinho.adicionarProduto(ebook);
                        System.out.println(ebook.nome + " adicionado ao carrinho.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("\nSeu carrinho:");
                    System.out.println("Total: R$ " + carrinho.getTotal());
                    break;

                case 3:
                    System.out.print("Digite o código do cupom de desconto: ");
                    String codigoCupom = scanner.nextLine();
                    GerenciadorCupons gerenciadorCupons = new GerenciadorCupons();
                    CupomDesconto cupom = gerenciadorCupons.verificarCupom(codigoCupom);
                    if (cupom != null) {
                        carrinho.aplicarCupom(cupom);
                        System.out.println("Cupom aplicado com sucesso! Novo total: R$ " + carrinho.getTotal());
                    } else {
                        System.out.println("Cupom inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Informe o endereço para entrega: ");
                    String enderecoEntrega = scanner.nextLine();
                    Frete frete = new Frete(enderecoEntrega, 10); // Exemplo de distância fixa
                    frete.exibirDetalhesFrete();

                    System.out.println("\nEscolha o método de pagamento:");
                    System.out.println("1. Cartão de Crédito");
                    System.out.println("2. Boleto");
                    int metodoPagamentoEscolhido = scanner.nextInt();
                    MetodoPagamento metodoPagamento;

                    if (metodoPagamentoEscolhido == 1) {
                        metodoPagamento = new PagamentoCartao();
                    } else {
                        metodoPagamento = new PagamentoBoleto();
                    }

                    carrinho.finalizarCompra(cliente, metodoPagamento);
                    System.out.println("Compra finalizada com sucesso!");

                    System.out.println("\nHistórico de pedidos:");
                    cliente.exibirHistorico();
                    break;

                case 5:
                    System.out.println("Obrigado por usar nosso sistema. Até logo!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}