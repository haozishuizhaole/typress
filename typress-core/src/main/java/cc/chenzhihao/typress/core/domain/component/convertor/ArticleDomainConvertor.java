package cc.chenzhihao.typress.core.domain.component.convertor;

import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * 文章领域转换器
 *
 * @author chenzhihao
 * @date 2023-09-20 17:40
 */
@Mapper
public interface ArticleDomainConvertor {

    /**
     * ArticleId -> Long
     */
    @Named("convertArticleIdToLong")
    default Long convertArticleIdToLong(ArticleId source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getId();
    }

    /**
     * Long -> ArticleId
     */
    @Named("convertLongToArticleId")
    default ArticleId convertLongToArticleId(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return new ArticleId(source);
    }
}
