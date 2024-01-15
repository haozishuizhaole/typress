package cc.chenzhihao.typress.infras.persistence.impl.sqlite;

import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.core.component.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.article.entity.Article;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.core.infras.persistence.ArticlePersistence;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.convertor.ArticlePersistenceConvertor;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ext.ArticlePOExtMapper;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ArticlePO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基于SQLite的文章持久层实现
 *
 * @author chenzhihao
 * @date 2024-01-15 20:15
 */
@Component
public class SQLiteArticlePersistence implements ArticlePersistence {

    @Resource
    private ArticlePOExtMapper mapper;

    @Override
    public void create(Article entity) throws PersistenceException {
        ArticlePO po = ArticlePersistenceConvertor.convertArticleToArticlePO(entity);

        try {
            mapper.insert(po);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#insert failed", e);
        }
    }

    @Override
    public int updateByConditionSelective(Article entityData, ArticleCondition condition) throws PersistenceException {
        ArticlePO data = ArticlePersistenceConvertor.convertArticleToArticlePO(entityData);
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);
        try {
            return mapper.updateByExampleSelective(data, example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#updateByExampleSelective error", e);
        }
    }

    @Override
    public Article getById(ArticleID id) throws PersistenceException {
        ArticleCondition condition = new ArticleCondition();
        condition.createCriteria().articleIDEqualTo(id);
        List<Article> articles = findByCondition(condition);
        if (CollectionUtils.isEmpty(articles)) {
            return null;
        }
        return articles.get(0);
    }

    @Override
    public List<Article> findByCondition(ArticleCondition condition) throws PersistenceException {
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);
        List<ArticlePO> pos;
        try {
            pos = mapper.selectByExtExample(example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#selectByExtExample failed", e);
        }

        return ArticlePersistenceConvertor.convertArticlePOToArticle(pos);
    }

    @Override
    public long countByCondition(ArticleCondition condition) throws PersistenceException {
        ArticlePOExtExample example = ArticlePersistenceConvertor.convertArticleConditionToArticlePOExtExample(condition);
        try {
            return mapper.countByExample(example);
        } catch (Exception e) {
            throw new PersistenceException("execute ArticlePOExtMapper#selectByExtExample failed", e);
        }
    }

    @Override
    public void delete(ArticleID identity) throws PersistenceException {
        ArticlePersistence.super.delete(identity);
    }
}
