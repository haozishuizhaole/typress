package cc.chenzhihao.typress.commons.util;

import cc.chenzhihao.typress.commons.model.vo.databinder.CommonJsonModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON 工具
 *
 * @author chenzhihao
 * @date 2023-12-22 22:39
 */
public class JSONUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        registerModel(new CommonJsonModule());
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    public static void registerModel(Module module) {
        MAPPER.registerModule(module);
    }

    public static <T> String serialize(T obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json serialize failed", e);
        }
    }

    public static <T> T deserialize(String json, Class<T> clz) {
        try {
            return MAPPER.readValue(json, clz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json deserialize failed", e);
        }
    }

    public static <T> T deserialize(String json, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json deserialize failed", e);
        }
    }

    public static JsonNode read(String json) {
        try {
            return MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json read failed", e);
        }
    }

}
