package cc.chenzhihao.typress.core.business.usecase.impl;

import cc.chenzhihao.typress.core.business.usecase.ArticleUseCases;
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

    
}
