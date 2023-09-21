package cc.chenzhihao.typress.core.business.usecase.impl;

import cc.chenzhihao.typress.core.business.convertor.ArticleBusinessConvertor;
import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.exception.BusinessException;
import cc.chenzhihao.typress.core.business.usecase.ArticleUseCases;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;

/**
 * 文章用例实现
 *
 * @author chenzhihao
 * @date 2023-09-20 20:11
 */
public class ArticleUseCasesImpl implements ArticleUseCases {

    private final ArticleRepository articleRepository;

    public ArticleUseCasesImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public GetArticleInfoResponseDTO getArticleInfo(Long articleId) {
        Article article;
        try {
            article = articleRepository.getById(new ArticleId(articleId));
        } catch (RepositoryException e) {
            throw new BusinessException("get article info by articleId failed", e);
        }

        return ArticleBusinessConvertor.convertArticleToGetArticleInfoResponseDTO(article);
    }
}
