package cc.chenzhihao.typress.core.business.usecase.impl;

import cc.chenzhihao.typress.core.business.convertor.ArticleBusinessConvertor;
import cc.chenzhihao.typress.core.business.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.business.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.exception.BusinessException;
import cc.chenzhihao.typress.core.business.usecase.ArticleUseCases;
import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleAbstractInfo;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;
import cc.chenzhihao.typress.core.utils.ValidateUtil;

import java.util.List;

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

    @Override
    public SaveArticleInfoResponseDTO saveArticleInfo(SaveArticleInfoRequestDTO request) {
        // 参数校验
        ValidateUtil.validate(request);

        // 数据转换
        Article article = ArticleBusinessConvertor.convertSaveArticleInfoRequestDTOToArticle(request);

        // 保存文章
        try {
            articleRepository.save(article);
        } catch (RepositoryException e) {
            throw new BusinessException("save article failed", e);
        }

        return new SaveArticleInfoResponseDTO(article.getArticleId().getId());
    }

    @Override
    public FindArticlesResponseDTO findArticles(FindArticlesRequestDTO request) {
        // 参数校验
        ValidateUtil.validate(request);

        // 构造查询条件
        ArticleCondition queryCondition = ArticleBusinessConvertor.convertFindArticlesRequestDTOToArticleCondition(request);

        // 查总数
        long totalCount;
        try {
            totalCount = articleRepository.countByCondition(queryCondition);
        } catch (RepositoryException e) {
            throw new BusinessException("query article count by condition failed", e);
        }

        // 查记录
        List<ArticleAbstractInfo> articleAbstractInfos;
        try {
            articleAbstractInfos = articleRepository.getArticleAbstractInfoByCondition(queryCondition);
        } catch (RepositoryException e) {
            throw new BusinessException("query article abstract infos by condition failed", e);
        }

        // 组装数据
        return ArticleBusinessConvertor.assembleFindArticlesResponseDTO(totalCount, articleAbstractInfos);
    }

    @Override
    public void deleteArticle(Long articleId) {
        try {
            articleRepository.delete(new ArticleId(articleId));
        } catch (RepositoryException e) {
            throw new BusinessException("delete article by articleId failed", e);
        }
    }
}
