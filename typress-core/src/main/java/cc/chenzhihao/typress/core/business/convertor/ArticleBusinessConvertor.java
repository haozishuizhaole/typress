package cc.chenzhihao.typress.core.business.convertor;

import cc.chenzhihao.typress.core.business.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.business.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.domain.component.convertor.ArticleDomainConvertor;
import cc.chenzhihao.typress.core.domain.component.convertor.CommonDomainConvertor;
import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.condition.base.PageRequest;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleAbstractInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

/**
 * 文章业务层转换器
 *
 * @author chenzhihao
 * @date 2023-09-20 20:29
 */
public class ArticleBusinessConvertor {

    private static final ArticleConvertor MAPPER = Mappers.getMapper(ArticleConvertor.class);

    public static GetArticleInfoResponseDTO convertArticleToGetArticleInfoResponseDTO(Article source) {
        return MAPPER.convertArticleToGetArticleInfoResponseDTO(source);
    }

    public static Article convertSaveArticleInfoRequestDTOToArticle(SaveArticleInfoRequestDTO source) {
        return MAPPER.convertSaveArticleInfoRequestDTOToArticle(source);
    }

    public static ArticleCondition convertFindArticlesRequestDTOToArticleCondition(FindArticlesRequestDTO source) {
        if (Objects.isNull(source)) {
            return null;
        }

        ArticleCondition target = new ArticleCondition();
        if (Objects.nonNull(source.getPageNo()) && Objects.nonNull(source.getPageSize())) {
            target.setPageable(PageRequest.of(source.getPageNo(), source.getPageSize()));
        }

        return target;
    }

    public static FindArticlesResponseDTO assembleFindArticlesResponseDTO(long totalCount, List<ArticleAbstractInfo> articleAbstractInfos) {
        return new FindArticlesResponseDTO(totalCount, MAPPER.convertArticleAbstractInfosToFindArticlesResponseDTO$Articles(articleAbstractInfos));
    }

    @Mapper(
            imports = {ArticleDomainConvertor.class, CommonDomainConvertor.class},
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
    )
    interface ArticleConvertor extends ArticleDomainConvertor, CommonDomainConvertor {

        @Mappings({
                @Mapping(target = "articleId", source = "articleId", qualifiedByName = "convertArticleIdToLong"),
                @Mapping(target = "articleContent", source = "articleContent", qualifiedByName = "convertMarkdownTextToRenderedTextString"),
                @Mapping(target = "createTime", source = "createTime", qualifiedByName = "convertTimestampToLong"),
                @Mapping(target = "updateTime", source = "updateTime", qualifiedByName = "convertTimestampToLong")
        })
        GetArticleInfoResponseDTO convertArticleToGetArticleInfoResponseDTO(Article source);

        @Mappings({
                @Mapping(target = "articleId", source = "articleId", qualifiedByName = "convertLongToArticleId"),
                @Mapping(target = "articleContent", source = "articleContent", qualifiedByName = "convertOriginalTextStringToMarkdownText"),
        })
        Article convertSaveArticleInfoRequestDTOToArticle(SaveArticleInfoRequestDTO source);

        @Mappings({
                @Mapping(target = "articleId", source = "articleId", qualifiedByName = "convertArticleIdToLong"),
        })
        FindArticlesResponseDTO.Article convertArticleAbstractInfoToFindArticlesResponseDTO$Article(ArticleAbstractInfo source);

        List<FindArticlesResponseDTO.Article> convertArticleAbstractInfosToFindArticlesResponseDTO$Articles(List<ArticleAbstractInfo> source);
    }
}
