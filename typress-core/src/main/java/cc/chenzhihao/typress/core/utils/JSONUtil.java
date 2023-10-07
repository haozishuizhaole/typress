package cc.chenzhihao.typress.core.utils;

import cc.chenzhihao.typress.core.domain.model.vo.Password;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.lang.reflect.Type;

/**
 * JSON工具
 *
 * @author chenzhihao
 * @date 2023-09-27 17:08
 */
public class JSONUtil {

    static {
        addSerializers();
        addDeserializers();
    }

    private static void addSerializers() {
        SerializeConfig globalSerializeConfig = SerializeConfig.getGlobalInstance();
        globalSerializeConfig.put(Password.class, (serializer, object, fieldName, fieldType, features) -> {
            String value = ((Password) object).getValue();
            serializer.write(value);
        });
    }

    private static void addDeserializers() {
        ParserConfig globalParserConfig = ParserConfig.getGlobalInstance();
        globalParserConfig.putDeserializer(Password.class, new ObjectDeserializer() {
            @Override
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
                String s = parser.parseObject(String.class);
                return (T) new Password(s, false);
            }
        });
    }


    public static <T> T parseObject(String jsonStr, Type type) {
        return JSON.parseObject(jsonStr, type);
    }

    public static String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

}
