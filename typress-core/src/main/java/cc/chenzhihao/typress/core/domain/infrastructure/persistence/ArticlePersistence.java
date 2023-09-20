package cc.chenzhihao.typress.core.domain.infrastructure.persistence;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.base.Persistence;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;

/**
 * 文章持久层接口
 *
 * @author chenzhihao
 * @date 2023-09-19 20:22
 */
public interface ArticlePersistence extends Persistence<ArticleId, Article, ArticleCondition> {
}
