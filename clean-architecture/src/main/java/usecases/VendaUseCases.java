package usecases;

import entities.ProdutoEntity;
import entities.VendaEntity;
import entities.VendedorEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VendaUseCases {

    private static final int VALOR_MINIMO_PRODUTO = 10;

    public static VendaEntity RegistrarVenda(VendedorEntity vendedor, ArrayList<ProdutoEntity> produtos, LocalDateTime dataVenda) {

        ValidarDadosDaVenda(vendedor, produtos, dataVenda);
        VendaEntity venda = new VendaEntity(vendedor, dataVenda);
        for (ProdutoEntity produto : produtos) {
            venda.addProduto(produto);
        }
        ValidarTotalVenda(venda);
        return venda;
    }

    private static void ValidarTotalVenda(VendaEntity venda) {
        if (venda.getTotalVenda() < 0) {
            throw new IllegalArgumentException("Total da venda não pode ser negativo");
        }

        if (venda.getTotalVenda() == 0 && venda.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Total de itens inválido");
        }
    }


    private static void ValidarDadosDaVenda(VendedorEntity vendedor, ArrayList<ProdutoEntity> produtos, LocalDateTime dataVenda) {
        if (vendedor == null) {
            throw new IllegalArgumentException("Vendedor não pode ser nulo");
        }
        if (dataVenda.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data da venda não pode ser no futuro");
        }
        if (produtos == null) {
            throw new IllegalArgumentException("Produtos não podem ser nulos");
        }
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("Produtos não podem ser vazios");
        }

        for(ProdutoEntity produto : produtos) {
            if (produto == null) {
                throw new IllegalArgumentException("Produto não pode ser nulo");
            }
            if (produto.getPreco() < VALOR_MINIMO_PRODUTO) {
                throw new IllegalArgumentException("Produto não pode ser menor que R$ 10,00");
            }
        }

    }

}
