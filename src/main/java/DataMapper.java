import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataMapper {

    public VatData jsonStringToVatData(String jsonString) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        VatData vatData = objectMapper.readValue(jsonString, VatData.class);

        return vatData;
    }
}
