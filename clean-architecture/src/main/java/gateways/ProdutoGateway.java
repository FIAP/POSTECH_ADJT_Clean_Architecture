package gateways;

import entities.ProdutoEntity;
import interfaces.IDatabaseClient;
import interfaces.IProdutoGateway;

public class ProdutoGateway implements IProdutoGateway {
    private final IDatabaseClient databaseClient;

    public ProdutoGateway(IDatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public ProdutoEntity ObterProdutoPorIdentificacao(String identificacao) {
        return this.databaseClient.ObterProdutoPorIdentificacao(identificacao);
    }
}
