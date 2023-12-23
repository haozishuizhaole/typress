package cc.chenzhihao.typress.commons.model.vo.databinder;

import cc.chenzhihao.typress.commons.model.vo.Password;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Password 数据绑定
 *
 * @author chenzhihao
 * @date 2023-12-23 15:01
 */
public class PasswordDataBinder implements DataBinder<Password> {

    private static final PasswordDataBinder INSTANCE = new PasswordDataBinder();

    private PasswordDataBinder() {
    }

    public static PasswordDataBinder getInstance() {
        return INSTANCE;
    }

    private final JsonSerializer<Password> jsonSerializer = new JsonSerializer<Password>() {
        @Override
        public void serialize(Password value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.getValue());
        }
    };

    private final JsonDeserializer<Password> jsonDeserializer = new JsonDeserializer<Password>() {

        @Override
        public Password deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new Password(p.readValueAs(String.class), false);
        }
    };

    @Override
    public JsonSerializer<Password> getJsonSerializer() {
        return jsonSerializer;
    }

    @Override
    public JsonDeserializer<Password> getJsonDeserializer() {
        return jsonDeserializer;
    }

}
