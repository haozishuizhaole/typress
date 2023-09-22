package cc.chenzhihao.typress.core.domain.infrastructure.persistence;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.base.Persistence;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleAbstractInfo;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;

import java.util.List;

/**
 * 文章持久层接口
 *
 * @author chenzhihao
 * @date 2023-09-19 20:22
 */
public interface ArticlePersistence extends Persistence<ArticleId, Article, ArticleCondition> {

    /**
     * 根据条件查询文章摘要信息
     *
     * @param condition 条件
     * @return 文章摘要信息列表
     */
    List<ArticleAbstractInfo> findArticleAbstractInfoByCondition(ArticleCondition condition) throws PersistenceException;
}
