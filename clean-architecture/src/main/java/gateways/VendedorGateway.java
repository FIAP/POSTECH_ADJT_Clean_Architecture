package gateways;

import entities.VendedorEntity;
import interfaces.IDatabaseClient;
import interfaces.IVendedorGateway;

public class VendedorGateway implements IVendedorGateway {

    private final IDatabaseClient databaseClient;
    public VendedorGateway(IDatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public VendedorEntity ObterVendedorPorIdentificacao(String identificacao) {
        return this.databaseClient.ObterVendedorPorIdentificacao(identificacao);
    }
}
