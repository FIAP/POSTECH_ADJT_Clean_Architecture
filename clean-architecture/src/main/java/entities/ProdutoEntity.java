package entities;

public final class ProdutoEntity {
    public final String nome, identificacao;
    public double preco;
    public double desconto = 0.0;

    public ProdutoEntity(String nome, String identificacao, double preco) {
        if (nome.isEmpty() || identificacao.isEmpty()) {
            throw new IllegalArgumentException("Nome e/ou identificação não podem ser vazios");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.nome = nome;
        this.identificacao = identificacao;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco * (1.0 - this.desconto);
    }

    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setDesconto(double desconto) {
        if (desconto < 0.0 || desconto > 100.0) {
            throw new IllegalArgumentException("Desconto deve ser um valor entre 0.0 e 100.0");
        }
        this.desconto = desconto / 100;
    }

    public void setDesconto(int desconto) {
        this.setDesconto((double) desconto);
    }
}
