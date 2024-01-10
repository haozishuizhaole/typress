package cc.chenzhihao.typress.commons.convertor;

import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.commons.util.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * @author chenzhihao
 * @date 2024-01-09 18:44
 */
@Mapper
public interface BaseConvertor {

    /**
     * Object -> String(json)
     */
    @Named("convertObjectToJsonString")
    default String convertObjectToJsonString(Object source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return JSONUtil.serialize(source);
    }

    /**
     * String(json) -> Object
     */
    @Named("convertJsonStringToObject")
    default <T> T convertJsonStringToObject(String source, @Context Class<T> clazz) {
        if (StringUtils.isBlank(source) || Objects.isNull(clazz)) {
            return null;
        }
        return JSONUtil.deserialize(source, clazz);
    }

    /**
     * Timestamp -> Long
     */
    @Named("convertTimestampToLong")
    default Long convertTimestampToLong(Timestamp source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getValue();
    }

    /**
     * Long -> Timestamp
     */
    @Named("convertLongToTimestamp")
    default Timestamp convertLongToTimestamp(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return new Timestamp(source);
    }

}
