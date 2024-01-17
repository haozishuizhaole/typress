package cc.chenzhihao.typress.commons.model.vo.databinder;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * @author chenzhihao
 * @date 2024-01-16 16:33
 */
public class LongDataBinder implements DataBinder<Long> {

    private static final LongDataBinder INSTANCE = new LongDataBinder();

    private LongDataBinder() {
    }

    public static LongDataBinder getInstance() {
        return INSTANCE;
    }

    private final JsonSerializer<Long> jsonSerializer = new JsonSerializer<Long>() {
        @Override
        public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (Objects.isNull(value)) {
                gen.writeNull();
                return;
            }
            gen.writeString(String.valueOf(value));
        }
    };

    private final JsonDeserializer<Long> jsonDeserializer = new JsonDeserializer<Long>() {

        @Override
        public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            String value = p.readValueAs(String.class);
            if (StringUtils.isBlank(value)) {
                return null;
            }
            return Long.valueOf(value);
        }
    };

    @Override
    public JsonSerializer<Long> getJsonSerializer() {
        return jsonSerializer;
    }

    @Override
    public JsonDeserializer<Long> getJsonDeserializer() {
        return jsonDeserializer;
    }
}
