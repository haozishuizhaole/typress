package cc.chenzhihao.typress.core.domain.component.convertor;

import cc.chenzhihao.typress.core.domain.model.vo.MarkdownText;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * 通用领域转换器
 *
 * @author chenzhihao
 * @date 2023-09-20 19:18
 */
@Mapper
public interface CommonDomainConvertor {

    @Named("convertTimestampToLong")
    default Long convertTimestampToLong(Timestamp source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getValue();
    }

    @Named("convertLongToTimestamp")
    default Timestamp convertLongToTimestamp(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return new Timestamp(source);
    }

    @Named("convertMarkdownTextToRenderedTextString")
    default String convertMarkdownTextToRenderedTextString(MarkdownText source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getRenderedText();
    }

    @Named("convertMarkdownTextToOriginalTextString")
    default String convertMarkdownTextToOriginalTextString(MarkdownText source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getOriginalText();
    }

}
