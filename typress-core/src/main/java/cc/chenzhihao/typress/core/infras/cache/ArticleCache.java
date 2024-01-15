package cc.chenzhihao.typress.core.infras.cache;

import cc.chenzhihao.typress.commons.component.cache.Cache;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;

/**
 * 文章缓存
 *
 * @author chenzhihao
 * @date 2024-01-12 17:53
 */
public interface ArticleCache extends Cache<ArticleID, Article> {
}
