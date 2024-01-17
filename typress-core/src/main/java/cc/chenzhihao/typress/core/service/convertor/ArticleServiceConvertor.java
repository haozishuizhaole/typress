package cc.chenzhihao.typress.core.service.convertor;

import cc.chenzhihao.typress.core.domain.article.convertor.ArticleCoreConvertor;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.service.dto.resp.GetArticleRenderedInfoByIDResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * 文章业务层转换器
 *
 * @author chenzhihao
 * @date 2024-01-16 14:56
 */
public class ArticleServiceConvertor {

    private static final ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

    /**
     * Article -> GetArticleRenderedInfoByIDResponseDTO
     */
    public static GetArticleRenderedInfoByIDResponseDTO convertArticleToGetArticleByIDResponseDTO(Article source) {
        return MAPPER.convertArticleToGetArticleByIDResponseDTO(source);
    }


    @Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    interface ArticleMapper extends ArticleCoreConvertor {

        @Mappings({
                @Mapping(target = "articleId", qualifiedByName = convertArticleIDToLong),
                @Mapping(target = "articleContent", qualifiedByName = convertMarkdownTextToRenderedString),
                @Mapping(target = "createTime", qualifiedByName = convertTimestampToLong),
                @Mapping(target = "updateTime", qualifiedByName = convertTimestampToLong),
        })
        GetArticleRenderedInfoByIDResponseDTO convertArticleToGetArticleByIDResponseDTO(Article source);
    }

}