package cc.chenzhihao.typress.commons.convertor;

import cc.chenzhihao.typress.commons.model.vo.MarkdownText;
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
     * Object -> Json(String)
     */
    String convertObjectToJsonString = "convertObjectToJsonString";

    /**
     * Json(String) -> Object
     */
    String convertJsonStringToObject = "convertJsonStringToObject";

    /**
     * Timestamp -> Long
     */
    String convertTimestampToLong = "convertTimestampToLong";

    /**
     * Long -> Timestamp
     */
    String convertLongToTimestamp = "convertLongToTimestamp";

    /**
     * MarkdownText -> original(String)
     */
    String convertMarkdownTextToOriginalString = "convertMarkdownTextToOriginalString";

    /**
     * MarkdownText -> Rendered(String)
     */
    String convertMarkdownTextToRenderedString = "convertMarkdownTextToRenderedString";

    /**
     * original(String) -> MarkdownText
     */
    String convertOriginalStringToMarkdownText = "convertOriginalStringToMarkdownText";

    /**
     * original(String) + Rendered(String) -> MarkdownText
     */
    String convertOriginalAndRenderedStringToMarkdownText = "convertOriginalAndRenderedStringToMarkdownText";


    /**
     * Object -> String(json)
     */
    @Named(convertObjectToJsonString)
    default String convertObjectToJsonString(Object source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return JSONUtil.serialize(source);
    }

    /**
     * String(json) -> Object
     */
    @Named(convertJsonStringToObject)
    default <T> T convertJsonStringToObject(String source, @Context Class<T> clazz) {
        if (StringUtils.isBlank(source) || Objects.isNull(clazz)) {
            return null;
        }
        return JSONUtil.deserialize(source, clazz);
    }

    /**
     * Timestamp -> Long
     */
    @Named(convertTimestampToLong)
    default Long convertTimestampToLong(Timestamp source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getValue();
    }

    /**
     * Long -> Timestamp
     */
    @Named(convertLongToTimestamp)
    default Timestamp convertLongToTimestamp(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return new Timestamp(source);
    }

    /**
     * MarkdownText -> origin(String)
     */
    @Named(convertMarkdownTextToOriginalString)
    default String convertMarkdownTextToOriginalString(MarkdownText source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getOriginalText();
    }

    /**
     * MarkdownText -> rendered(String)
     */
    @Named(convertMarkdownTextToRenderedString)
    default String convertMarkdownTextToRenderedString(MarkdownText source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getRenderedText();
    }

    /**
     * origin(String) -> MarkdownText
     */
    @Named(convertOriginalStringToMarkdownText)
    default MarkdownText convertOriginalStringToMarkdownText(String originalString) {
        if (Objects.isNull(originalString)) {
            return null;
        }
        return new MarkdownText(originalString);
    }

    /**
     * (origin(String) + rendered(String)) -> MarkdownText
     */
    @Named(convertOriginalAndRenderedStringToMarkdownText)
    default MarkdownText convertOriginalAndRenderedStringToMarkdownText(String originalString, String renderedString) {
        if (Objects.isNull(originalString) && Objects.isNull(renderedString)) {
            return null;
        }
        return new MarkdownText(originalString, renderedString);
    }
}
