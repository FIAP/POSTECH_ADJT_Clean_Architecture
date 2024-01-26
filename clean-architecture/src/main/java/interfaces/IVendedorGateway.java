package interfaces;
import entities.VendedorEntity;

public interface IVendedorGateway {
    public VendedorEntity ObterVendedorPorIdentificacao(String identificacao);
}
