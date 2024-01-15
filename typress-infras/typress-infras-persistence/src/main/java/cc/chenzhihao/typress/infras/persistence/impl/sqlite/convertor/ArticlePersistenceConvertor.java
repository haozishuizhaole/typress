package cc.chenzhihao.typress.infras.persistence.impl.sqlite.convertor;

import cc.chenzhihao.typress.commons.component.condition.Pageable;
import cc.chenzhihao.typress.core.component.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.article.convertor.ArticleCoreConvertor;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ArticlePOExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ArticlePO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Article 持久层转换器
 *
 * @author chenzhihao
 * @date 2024-01-15 20:11
 */
public class ArticlePersistenceConvertor {

    private static final ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

    public static ArticlePO convertArticleToArticlePO(Article source) {
        return MAPPER.convertArticleToArticlePO(source);
    }

    /**
     * ConfigCondition -> ConfigPOExtExample
     */
    public static ArticlePOExtExample convertArticleConditionToArticlePOExtExample(ArticleCondition source) {
        if (source == null) {
            return null;
        }

        // Base
        ArticlePOExtExample target = new ArticlePOExtExample(convertArticleConditionToArticlePOExample(source));

        // 分页
        Pageable sourcePageable = source.getPageable();
        if (sourcePageable != null) {
            target.limit(sourcePageable.getOffset(), sourcePageable.getPageSize());
        }
        return target;
    }

    /**
     * ArticleCondition -> ArticlePOExample
     */
    public static ArticlePOExample convertArticleConditionToArticlePOExample(ArticleCondition source) {
        if (source == null) {
            return null;
        }
        ArticlePOExample target = new ArticlePOExample();
        for (ArticleCondition.Criteria sourceCriterion : source.getOredCriteria()) {
            ArticlePOExample.Criteria targetOrCriteria = target.or();
            populateArticleConditionCriteriaByArticlePOExampleCriteria(sourceCriterion, targetOrCriteria);
        }
        return target;
    }

    /**
     * ArticleCondition.Criteria -> ArticlePOExample.Criteria
     */
    public static void populateArticleConditionCriteriaByArticlePOExampleCriteria(ArticleCondition.Criteria source, ArticlePOExample.Criteria target) {
        if (source == null) {
            return;
        }

        // articleID == ?
        if (source.getArticleIDEqualTo() != null) {
            target.andArticleIdEqualTo(source.getArticleIDEqualTo().getId());
        }

    }

    public static Article convertArticlePOToArticle(ArticlePO source) {
        return MAPPER.convertArticlePOToArticle(source);
    }

    public static List<Article> convertArticlePOToArticle(List<ArticlePO> source) {
        return MAPPER.convertArticlePOToArticle(source);
    }

    @Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    interface ArticleMapper extends ArticleCoreConvertor {

        @Mappings({
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "articleId", qualifiedByName = "convertArticleIDToLong"),
                @Mapping(target = "articleOriginalContent", source = "articleContent", qualifiedByName = "convertMarkdownTextToOriginalString"),
                @Mapping(target = "articleContent", source = "articleContent", qualifiedByName = "convertMarkdownTextToRenderedString"),
                @Mapping(target = "createTime", qualifiedByName = "convertTimestampToLong"),
                @Mapping(target = "updateTime", qualifiedByName = "convertTimestampToLong"),
        })
        ArticlePO convertArticleToArticlePO(Article source);

        @Mappings({
                @Mapping(target = "articleId", qualifiedByName = "convertLongToArticleID"),
                @Mapping(target = "articleContent", expression = "java(convertOriginalAndRenderedStringToMarkdownText(source.getArticleOriginalContent(),source.getArticleContent()))"),
                @Mapping(target = "createTime", qualifiedByName = "convertLongToTimestamp"),
                @Mapping(target = "updateTime", qualifiedByName = "convertLongToTimestamp"),
        })
        Article convertArticlePOToArticle(ArticlePO source);

        List<Article> convertArticlePOToArticle(List<ArticlePO> source);
    }

}
