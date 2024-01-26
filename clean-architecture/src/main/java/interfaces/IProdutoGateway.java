package interfaces;

import entities.ProdutoEntity;

public interface IProdutoGateway {
    public ProdutoEntity ObterProdutoPorIdentificacao(String identificacao);
}
