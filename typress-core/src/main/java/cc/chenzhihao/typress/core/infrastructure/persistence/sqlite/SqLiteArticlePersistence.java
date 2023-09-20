package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.convertor.ArticlePersistenceConvertor;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext.ArticlePOExtMapper;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ArticlePO;

import java.util.List;

/**
 * 基于SQLite文章持久层实现
 *
 * @author chenzhihao
 * @date 2023-09-20 11:49
 */
public class SqLiteArticlePersistence implements ArticlePersistence {

    private final ArticlePOExtMapper mapper;

    public SqLiteArticlePersistence(ArticlePOExtMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void create(Article entity) throws PersistenceException {
        ArticlePO po = ArticlePersistenceConvertor.convertArticleToArticlePOSelective(entity);
        try {
            mapper.insert(po);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#insert error", e);
        }
    }

    @Override
    public int updateByConditionSelective(Article entityData, ArticleCondition condition) throws PersistenceException {
        ArticlePO data = ArticlePersistenceConvertor.convertArticleToArticlePOSelective(entityData);
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);
        try {
            return mapper.updateByExampleSelective(data, example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#updateByExampleSelective error", e);
        }
    }

    @Override
    public List<Article> findByCondition(ArticleCondition condition) throws PersistenceException {
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);

        List<ArticlePO> pos;
        try {
            pos = mapper.selectByExtExample(example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#selectByExtExample error", e);
        }

        return ArticlePersistenceConvertor.convertArticlePOsToArticles(pos);
    }

    @Override
    public long countByCondition(ArticleCondition condition) throws PersistenceException {
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);
        try {
            return mapper.countByExample(example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#countByExample error", e);
        }
    }

    @Override
    public void delete(ArticleId identity) throws PersistenceException {
        ArticlePOExtExample example = new ArticlePOExtExample();
        example.createCriteria().andArticleIdEqualTo(identity.getId());
        try {
            mapper.deleteByExample(example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#deleteByExample error", e);
        }
    }
}
