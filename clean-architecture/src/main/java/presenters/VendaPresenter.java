package presenters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.VendaEntity;
import records.VendaRecord;

public class VendaPresenter {
    public static String ToJson(VendaEntity venda) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        return mapper.writeValueAsString(venda);
    }
}