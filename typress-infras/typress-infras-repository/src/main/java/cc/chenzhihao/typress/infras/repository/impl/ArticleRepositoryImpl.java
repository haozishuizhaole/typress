package cc.chenzhihao.typress.infras.repository.impl;

import cc.chenzhihao.typress.commons.exception.CacheException;
import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.core.component.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.core.infras.cache.ArticleCache;
import cc.chenzhihao.typress.core.infras.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.infras.repository.ArticleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Article资源库实现
 *
 * @author chenzhihao
 * @date 2024-01-15 20:44
 */
@Component
public class ArticleRepositoryImpl extends ArticleRepository {

    @Resource
    private ArticlePersistence articlePersistence;

    @Resource
    private ArticleCache articleCache;

    private final Lock CACHE_LOCK = new ReentrantLock();

    @Override
    public void save(Article entity) throws RepositoryException {
        // 新增
        if (!contains(entity.getArticleId())) {
            try {
                articlePersistence.create(entity);
                articleCache.set(entity.getArticleId(), entity);
            } catch (PersistenceException | CacheException e) {
                throw new RepositoryException("create article failed", e);
            }
            return;
        }

        // 更新
        ArticleCondition condition = new ArticleCondition();
        condition.createCriteria().articleIDEqualTo(entity.getArticleId());
        entity = new Article(entity.getArticleId(), entity.getArticleTitle(), entity.getArticleContent(), new Timestamp(), new Timestamp());
        try {
            articlePersistence.updateByConditionSelective(entity, condition);
            articleCache.set(entity.getArticleId(), entity);
        } catch (PersistenceException | CacheException e) {
            throw new RepositoryException("update article by condition selective failed", e);
        }
    }

    @Override
    public Article getById(ArticleID id) throws RepositoryException {
        // 从缓存获取
        Article article;
        try {
            // TODO 此处应该使用布隆过滤器，后边优化一下
            if (Objects.nonNull(article = articleCache.get(id))) {
                return article;
            }
        } catch (CacheException e) {
            throw new RepositoryException("get article by id from cache failed", e);
        }

        // 加锁进行读库更新缓存。只放行一个现成进行该操作，其余线程全部返回null
        if (!CACHE_LOCK.tryLock()) {
            return null;
        }

        // 查库更新缓存
        try {
            if (Objects.nonNull(article = articlePersistence.getById(id))) {
                articleCache.set(article.getArticleId(), article);
            }
            return article;
        } catch (PersistenceException e) {
            throw new RepositoryException("get article by id failed", e);
        } catch (CacheException e) {
            throw new RepositoryException("set article to cache failed", e);
        }
    }

    @Override
    public boolean contains(ArticleID id) throws RepositoryException {
        return Objects.nonNull(getById(id));
    }

    @Override
    public long countByCondition(ArticleCondition condition) throws RepositoryException {
        try {
            return articlePersistence.countByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("count by condition failed", e);
        }
    }

    @Override
    public List<Article> getByCondition(ArticleCondition condition) throws RepositoryException {
        try {
            return articlePersistence.findByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("get by condition failed", e);
        }
    }

}
