package records;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public record VendaRecord(
        ArrayList<ProdutoRecord> produtos,
        @JsonProperty("vendedor") VendedorRecord vendedor,
        @JsonProperty("data_venda")
        Date dataVenda
) {
}
