package records;

public record ProdutoRecord(
        String identificacao,
        String nome,
        double preco,
        double desconto
) {
}
