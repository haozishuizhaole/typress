package cc.chenzhihao.typress.infras.cache;

import cc.chenzhihao.typress.commons.component.cache.MemoryCache;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.core.infras.cache.ArticleCache;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * 基于内存的Article缓存
 *
 * @author chenzhihao
 * @date 2024-01-15 17:52
 */
@Component
public class MemoryArticleCache extends MemoryCache<ArticleID, Article> implements ArticleCache {
    private static final Duration duration = Duration.ofHours(12);

    public MemoryArticleCache() {
        super(duration);
    }
}
