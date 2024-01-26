package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.ProdutoEntity;
import entities.VendaEntity;
import entities.VendedorEntity;
import gateways.ProdutoGateway;
import gateways.VendaGateway;
import gateways.VendedorGateway;
import interfaces.IDatabaseClient;
import interfaces.IProdutoGateway;
import interfaces.IVendaGateway;
import interfaces.IVendedorGateway;
import records.ProdutoRecord;
import records.VendedorRecord;
import usecases.VendaUseCases;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VendaController {
    public VendaEntity RegistrarVenda(
            VendedorRecord vendedor,
            ArrayList<ProdutoRecord> produtos,
            IDatabaseClient databaseClient
    ) {
        IVendedorGateway vendedorGateway = new VendedorGateway(databaseClient);
        IVendaGateway vendaGateway = new VendaGateway(databaseClient);
        IProdutoGateway produtoGateway = new ProdutoGateway(databaseClient);

        var vendedorEntity = vendedorGateway.ObterVendedorPorIdentificacao(vendedor.identificacao());
        var produtosDaVenda = new ArrayList<ProdutoEntity>();
        for (ProdutoRecord produtoRecord : produtos) {
            ProdutoEntity produtoEntity = produtoGateway.ObterProdutoPorIdentificacao(produtoRecord.identificacao());
            if (produtoRecord.desconto() > 0) {
                produtoEntity.setDesconto(produtoRecord.desconto());
            }
            produtosDaVenda.add(produtoEntity);
        }

        var venda = VendaUseCases.RegistrarVenda(vendedorEntity, produtosDaVenda, LocalDateTime.now());

        // passou pelo use case, vamos registar no banco de dados
        vendaGateway.GravarVenda(venda);

        return venda;

//        try {
//            return VendaPresenter.ToJson(venda);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
