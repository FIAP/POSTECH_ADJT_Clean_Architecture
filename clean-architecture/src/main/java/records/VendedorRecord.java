package records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VendedorRecord(
        String nome,
        @JsonProperty("id") String identificacao) {
}
