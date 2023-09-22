package cc.chenzhihao.typress.core.domain.repository;

import cc.chenzhihao.typress.core.domain.condition.ArticleCondition;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleAbstractInfo;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import cc.chenzhihao.typress.core.domain.repository.base.Repository;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

/**
 * 文章资源库接口
 *
 * @author chenzhihao
 * @date 2023-09-19 20:27
 */
public interface ArticleRepository extends Repository<ArticleId, Article, ArticleCondition> {

    /**
     * 根据条件查询文章摘要信息
     *
     * @param condition 查询条件
     * @return 文章摘要信息列表
     * @throws RepositoryException 资源库异常
     */
    List<ArticleAbstractInfo> getArticleAbstractInfoByCondition(ArticleCondition condition) throws RepositoryException;

}
