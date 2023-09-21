package cc.chenzhihao.typress.core.business.convertor;

import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.domain.component.convertor.ArticleDomainConvertor;
import cc.chenzhihao.typress.core.domain.component.convertor.CommonDomainConvertor;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

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
    }
}
