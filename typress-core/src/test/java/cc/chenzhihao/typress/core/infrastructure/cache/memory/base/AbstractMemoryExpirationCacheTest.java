package cc.chenzhihao.typress.core.infrastructure.cache.memory.base;

import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import org.junit.Test;

import java.time.Duration;
import java.util.Objects;

/**
 * @author chenzhihao
 * @date 2023-10-08 16:39
 */
public class AbstractMemoryExpirationCacheTest {

    @Test
    public void expireAfterWrite() throws InterruptedException {
        MockCache cache = new MockCache(Duration.ofSeconds(2), ExpireTimePolicy.EXPIRE_AFTER_WRITE);

        ArticleId articleId = new ArticleId();
        Article article = new Article();
        cache.set(articleId, article);

        assert cache.contains(articleId);

        Thread.sleep(Duration.ofSeconds(2).toMillis());
        assert !cache.contains(articleId);
    }

    @Test
    public void expireAfterAccess() throws InterruptedException {
        MockCache cache = new MockCache(Duration.ofSeconds(2), ExpireTimePolicy.EXPIRE_AFTER_ACCESS);

        ArticleId articleId = new ArticleId();
        Article article = new Article();
        cache.set(articleId, article);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(Duration.ofSeconds(1).toMillis());
            assert Objects.nonNull(cache.get(articleId));
        }

        Thread.sleep(Duration.ofSeconds(2).toMillis());
        assert Objects.isNull(cache.get(articleId));
    }


    static class MockCache extends AbstractMemoryExpirationCache<ArticleId, Article> {

        public MockCache(Duration expireTime) {
            super(expireTime);
        }

        public MockCache(Duration expireTime, ExpireTimePolicy expireTimePolicy) {
            super(expireTime, expireTimePolicy);
        }
    }
}