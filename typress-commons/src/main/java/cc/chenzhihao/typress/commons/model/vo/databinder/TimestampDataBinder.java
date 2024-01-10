package cc.chenzhihao.typress.commons.model.vo.databinder;

import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

/**
 * Timestamp 数据绑定
 *
 * @author chenzhihao
 * @date 2024-01-10 19:22
 */
public class TimestampDataBinder implements DataBinder<Timestamp> {

    private static final TimestampDataBinder INSTANCE = new TimestampDataBinder();

    private final JsonSerializer<Timestamp> jsonSerializer = new JsonSerializer<Timestamp>() {
        @Override
        public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (Objects.isNull(value)) {
                gen.writeNull();
            } else {
                gen.writeNumber(value.getValue());
            }
        }
    };

    private final JsonDeserializer<Timestamp> jsonDeserializer = new JsonDeserializer<Timestamp>() {

        @Override
        public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            Long value = p.readValueAs(Long.class);
            if (Objects.isNull(value)) {
                return null;
            }
            return new Timestamp(value);
        }
    };

    private TimestampDataBinder() {
    }

    public static TimestampDataBinder getInstance() {
        return INSTANCE;
    }


    @Override
    public JsonSerializer<Timestamp> getJsonSerializer() {
        return jsonSerializer;
    }

    @Override
    public JsonDeserializer<Timestamp> getJsonDeserializer() {
        return jsonDeserializer;
    }
}
