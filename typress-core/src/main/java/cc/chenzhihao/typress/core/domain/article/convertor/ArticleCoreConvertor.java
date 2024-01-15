package cc.chenzhihao.typress.core.domain.article.convertor;

import cc.chenzhihao.typress.commons.convertor.BaseConvertor;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * 文章 核心转换器
 *
 * @author chenzhihao
 * @date 2024-01-15 16:57
 */
@Mapper
public interface ArticleCoreConvertor extends BaseConvertor {

    /**
     * ArticleID -> Long
     */
    @Named("convertArticleIDToLong")
    default Long convertArticleIDToLong(ArticleID source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.getId();
    }

    /**
     * Long -> ArticleID
     */
    @Named("convertLongToArticleID")
    default ArticleID convertLongToArticleID(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return new ArticleID(source);
    }
}
