package gateways;

import entities.VendaEntity;
import interfaces.IDatabaseClient;
import interfaces.IVendaGateway;

public class VendaGateway implements IVendaGateway {
    private final IDatabaseClient databaseClient;

    public VendaGateway(IDatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public void GravarVenda(VendaEntity venda) {
        this.databaseClient.GravarVenda(venda);
    }
}
