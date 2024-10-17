public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getEnderecoCompleto() {
        return rua + ", " + cidade + " - " + estado + " - CEP: " + cep;
    }
}