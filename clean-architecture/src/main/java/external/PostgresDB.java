package external;

import entities.ProdutoEntity;
import entities.VendaEntity;
import entities.VendedorEntity;
import interfaces.IDatabaseClient;

public class PostgresDB implements IDatabaseClient {
    @Override
    public ProdutoEntity ObterProdutoPorIdentificacao(String identificacao) {
        // TODO codigo postgres para buscar os dados e retornar
        return null;
    }

    @Override
    public void GravarVenda(VendaEntity venda) {
        // TODO codigo postgres para gravar no banco de dados
    }

    @Override
    public VendedorEntity ObterVendedorPorIdentificacao(String identificacao) {
        // TODO codigo postgres para buscar os dados e retornar
        return null;
    }
}
