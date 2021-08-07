import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class CustomDeserialize extends StdDeserializer<BigDecimal> {

    public CustomDeserialize() {
        this(null);
    }

    public CustomDeserialize(Class<BigDecimal> t){
        super(t);
    }

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String value = jsonParser.getText();

        if (value.equals("false")){
            return null;
        }

        return new BigDecimal(value);
    }
}
