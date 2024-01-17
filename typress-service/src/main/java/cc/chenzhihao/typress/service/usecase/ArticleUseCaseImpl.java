package cc.chenzhihao.typress.service.usecase;

import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.exception.ServiceException;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.core.infras.repository.ArticleRepository;
import cc.chenzhihao.typress.core.service.convertor.ArticleServiceConvertor;
import cc.chenzhihao.typress.core.service.dto.resp.GetArticleOriginalInfoByIDResponseDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetArticleRenderedInfoByIDResponseDTO;
import cc.chenzhihao.typress.core.service.usecase.ArticleUseCase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 文章用例实现
 *
 * @author chenzhihao
 * @date 2024-01-16 15:04
 */
@Service
public class ArticleUseCaseImpl implements ArticleUseCase {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public GetArticleOriginalInfoByIDResponseDTO getArticleOriginalInfoByID(ArticleID id) throws ServiceException {
        return null;
    }

    @Override
    public GetArticleRenderedInfoByIDResponseDTO getArticleRenderedInfoByID(ArticleID id) throws ServiceException {
        if (Objects.isNull(id)) {
            return null;
        }

        Article article;
        try {
            if (Objects.isNull(article = articleRepository.getById(id))) {
                return null;
            }
        } catch (RepositoryException e) {
            throw new ServiceException("get article by id from article repository failed", e);
        }

        return ArticleServiceConvertor.convertArticleToGetArticleByIDResponseDTO(article);
    }
}
