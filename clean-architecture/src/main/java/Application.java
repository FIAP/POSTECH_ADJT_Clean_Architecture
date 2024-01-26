import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.VendaController;
import entities.VendaEntity;
import external.PostgresDB;
import presenters.VendaPresenter;
import records.ProdutoRecord;
import records.VendedorRecord;

import java.util.ArrayList;

public class Application {

    public static void Main(String[] args) throws JsonProcessingException {
        PostgresDB postgresDB = new PostgresDB();
        VendaController vendaController = new VendaController();

        var vendedorData = new VendedorRecord(null, "aa4d1d39-0765-403c-be17-1a30564b0664");
        ArrayList<ProdutoRecord> listaProdutos = new ArrayList<>();
        listaProdutos.add(new ProdutoRecord(
                "f7c1dc96-ce58-415b-8736-f8d85b4ba661",
                "sapato",
                100,
                0)
        );
        listaProdutos.add(new ProdutoRecord(
                "1ce08b44-a98b-4edd-a3f9-440e16887df4",
                "bolsa",
                130,
                12)
        );
        listaProdutos.add(new ProdutoRecord(
                "1ce08b44-a98b-4edd-a3f9-440e16887df4",
                "bolsa",
                130,
                0)
        );

        VendaEntity venda = vendaController.RegistrarVenda(
                vendedorData,
                listaProdutos,
                postgresDB
        );

        var venda_em_json = VendaPresenter.ToJson(venda);
    }
}
