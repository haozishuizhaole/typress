package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.convertor;

import cc.chenzhihao.typress.core.domain.component.convertor.ArticleDomainConvertor;
import cc.chenzhihao.typress.core.domain.component.convertor.CommonDomainConvertor;
import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.condition.base.Pageable;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ArticlePOExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ArticlePO;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章持久层转换器
 *
 * @author chenzhihao
 * @date 2023-09-20 17:29
 */
public class ArticlePersistenceConvertor {

    private static final ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

    public static List<Article> convertArticlePOsToArticles(List<ArticlePO> source) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        return source.stream().map(ArticlePersistenceConvertor::convertArticlePOToArticle).collect(Collectors.toList());
    }

    public static Article convertArticlePOToArticle(ArticlePO source) {
        return MAPPER.convertArticlePOToArticle(source);
    }

    public static ArticlePO convertArticleToArticlePOSelective(Article source) {
        return MAPPER.convertArticleToArticlePO(source);
    }

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

    public static void populateArticleConditionCriteriaByArticlePOExampleCriteria(ArticleCondition.Criteria source, ArticlePOExample.Criteria target) {
        if (source == null) {
            return;
        }

        if (source.getArticleIdEqualTo() != null) {
            target.andArticleIdEqualTo(source.getArticleIdEqualTo().getId());
        }

    }

    @Mapper(
            imports = {ArticleDomainConvertor.class, CommonDomainConvertor.class},
            nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
    )
    interface ArticleMapper extends ArticleDomainConvertor, CommonDomainConvertor {

        @Mappings({
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "articleId", source = "articleId", qualifiedByName = "convertArticleIdToLong"),
                @Mapping(target = "articleOriginalContent", source = "articleContent", qualifiedByName = "convertMarkdownTextToRenderedTextString"),
                @Mapping(target = "articleContent", source = "articleContent", qualifiedByName = "convertMarkdownTextToOriginalTextString"),
                @Mapping(target = "createTime", source = "createTime", qualifiedByName = "convertTimestampToLong"),
                @Mapping(target = "updateTime", source = "updateTime", qualifiedByName = "convertTimestampToLong"),
        })
        ArticlePO convertArticleToArticlePO(Article source);

        @Mappings({
                @Mapping(target = "articleId", source = "articleId", qualifiedByName = "convertLongToArticleId"),
                @Mapping(target = "articleContent", expression = "java(new cc.chenzhihao.typress.core.domain.model.vo.MarkdownText(source.getArticleOriginalContent(),source.getArticleContent()))"),
                @Mapping(target = "createTime", source = "createTime", qualifiedByName = "convertLongToTimestamp"),
                @Mapping(target = "updateTime", source = "updateTime", qualifiedByName = "convertLongToTimestamp")
        })
        Article convertArticlePOToArticle(ArticlePO source);
    }
}
