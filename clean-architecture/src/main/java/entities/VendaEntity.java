package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VendaEntity {
    private final LocalDateTime dataVenda;
    private final VendedorEntity vendedor;
    private final ArrayList<ProdutoEntity> produtos;

    public VendaEntity(VendedorEntity vendedor, LocalDateTime dataVenda) {
        this.vendedor = vendedor;
        this.produtos = new ArrayList<ProdutoEntity>();
        this.dataVenda = dataVenda;
    }

    public VendedorEntity getVendedor() {
        return this.vendedor;
    }

    public LocalDateTime getDataVenda() {
        return this.dataVenda;
    }

    public void addProduto(ProdutoEntity produto) {
        this.produtos.add(produto);
    }

    public ArrayList<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public double getTotalVenda() {
        double total = 0.0;
        for (ProdutoEntity produto : this.produtos) {
            total += produto.getPreco();
        }
        return total;
    }

}