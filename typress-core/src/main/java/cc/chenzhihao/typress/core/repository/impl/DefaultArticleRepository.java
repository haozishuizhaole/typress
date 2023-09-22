package cc.chenzhihao.typress.core.repository.impl;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleAbstractInfo;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * 默认文章资源库实现
 *
 * @author chenzhihao
 * @date 2023-09-19 20:29
 */
public class DefaultArticleRepository implements ArticleRepository {

    private final ArticlePersistence articlePersistence;

    public DefaultArticleRepository(ArticlePersistence articlePersistence) {
        this.articlePersistence = articlePersistence;
    }

    @Override
    public void save(Article entity) throws RepositoryException {
        Timestamp now = new Timestamp();
        ArticleId articleId = entity.getArticleId();
        if (Objects.isNull(articleId)) {
            // 新增
            entity.setArticleId(new ArticleId());
            entity.setCreateTime(now);
            entity.setUpdateTime(now);
            try {
                articlePersistence.create(entity);
            } catch (PersistenceException e) {
                throw new RepositoryException("create article failed.", e);
            }
            return;
        }

        // 更新
        ArticleCondition updateCondition = new ArticleCondition();
        updateCondition.createCriteria().articleIdEqualTo(entity.getArticleId());
        entity.setUpdateTime(now);
        try {
            articlePersistence.updateByConditionSelective(entity, updateCondition);
        } catch (PersistenceException e) {
            throw new RepositoryException("update article by condition failed.", e);
        }
    }

    @Override
    public void delete(ArticleId id) throws RepositoryException {
        try {
            articlePersistence.delete(id);
        } catch (PersistenceException e) {
            throw new RepositoryException("get article by articleId failed", e);
        }
    }

    @Override
    public Article getById(ArticleId id) throws RepositoryException {
        try {
            return getByArticleIdFromPersistence(id);
        } catch (PersistenceException e) {
            throw new RepositoryException("get article by articleId failed", e);
        }
    }

    @Override
    public long countByCondition(ArticleCondition condition) throws RepositoryException {
        try {
            return articlePersistence.countByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("get article count by condition failed", e);
        }
    }

    @Override
    public List<Article> getByCondition(ArticleCondition condition) throws RepositoryException {
        try {
            return articlePersistence.findByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("find articles by condition failed", e);
        }
    }


    private Article getByArticleIdFromPersistence(ArticleId articleId) throws PersistenceException {
        ArticleCondition condition = new ArticleCondition();
        condition.createCriteria().articleIdEqualTo(articleId);
        List<Article> configs = articlePersistence.findByCondition(condition);
        if (CollectionUtils.isEmpty(configs)) {
            return null;
        }
        return configs.get(0);
    }

    @Override
    public List<ArticleAbstractInfo> getArticleAbstractInfoByCondition(ArticleCondition condition) throws RepositoryException {
        try {
            return articlePersistence.findArticleAbstractInfoByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("find article abstract info by condition failed", e);
        }
    }
}
