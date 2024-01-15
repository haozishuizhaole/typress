package cc.chenzhihao.typress.core.infras.persistence;

import cc.chenzhihao.typress.commons.component.persistence.Persistence;
import cc.chenzhihao.typress.core.component.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;

/**
 * 文章持久层
 *
 * @author chenzhihao
 * @date 2024-01-15 16:55
 */
public interface ArticlePersistence extends Persistence<ArticleID, Article, ArticleCondition> {
}
