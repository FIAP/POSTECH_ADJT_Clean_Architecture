package interfaces;

import entities.VendaEntity;
import interfaces.IDatabaseClient;

public interface IVendaGateway {
    public void GravarVenda(VendaEntity venda);
}
