package cc.chenzhihao.typress.core.domain.repository;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.domain.repository.base.Repository;

/**
 * 文章资源库接口
 *
 * @author chenzhihao
 * @date 2023-09-19 20:27
 */
public interface ArticleRepository extends Repository<ArticleId, Article, ArticleCondition> {
}
