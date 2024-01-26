package entities;

public class VendedorEntity {
    private final String nome;
    private final String identificacao;

    public VendedorEntity(String nome, String identificacao) {
        if (nome.isEmpty() || identificacao.isEmpty()) {
            throw new IllegalArgumentException("Nome e/ou identificação não podem ser vazios");
        }
        this.nome = nome;
        this.identificacao = identificacao;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIdentificacao() {
        return this.identificacao;
    }
}
