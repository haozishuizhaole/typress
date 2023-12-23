package cc.chenzhihao.typress.commons.model.vo.databinder;

import cc.chenzhihao.typress.commons.model.vo.Username;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Username 数据绑定
 *
 * @author chenzhihao
 * @date 2023-12-23 15:01
 */
public class UsernameDataBinder implements DataBinder<Username> {

    private static final UsernameDataBinder INSTANCE = new UsernameDataBinder();

    private UsernameDataBinder() {
    }

    public static UsernameDataBinder getInstance() {
        return INSTANCE;
    }

    private final JsonSerializer<Username> jsonSerializer = new JsonSerializer<Username>() {
        @Override
        public void serialize(Username value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.getValue());
        }
    };

    private final JsonDeserializer<Username> jsonDeserializer = new JsonDeserializer<Username>() {

        @Override
        public Username deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new Username(p.readValueAs(String.class));
        }
    };

    @Override
    public JsonSerializer<Username> getJsonSerializer() {
        return jsonSerializer;
    }

    @Override
    public JsonDeserializer<Username> getJsonDeserializer() {
        return jsonDeserializer;
    }

}
