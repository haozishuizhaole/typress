package cc.chenzhihao.typress.core.infras.repository;

import cc.chenzhihao.typress.commons.component.repository.Repository;
import cc.chenzhihao.typress.core.component.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;

/**
 * 文章资源库
 *
 * @author chenzhihao
 * @date 2024-01-15 16:56
 */
public class ArticleRepository implements Repository<ArticleID, Article, ArticleCondition> {
}
