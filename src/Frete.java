public class Frete {
    private String enderecoEntrega;
    private double custo;

    public Frete(String enderecoEntrega, double distancia) {
        this.enderecoEntrega = enderecoEntrega;
        calcularCusto(distancia);
    }

    private void calcularCusto(double distancia) {
        this.custo = distancia * 1.5; // Exemplo de cálculo simples por distância
    }

    public double getCusto() {
        return custo;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void exibirDetalhesFrete() {
        System.out.println("Entrega para: " + enderecoEntrega + " - Custo do frete: " + custo);
    }
}