package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext;

import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ArticlePOExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.base.Limit;

/**
 * @author chenzhihao
 * @date 2023-09-20 11:58
 */
public class ArticlePOExtExample extends ArticlePOExample {

    private Limit limit;

    public ArticlePOExtExample() {
    }

    public ArticlePOExtExample(ArticlePOExample example) {
        orderByClause = example.getOrderByClause();
        distinct = example.isDistinct();
        oredCriteria = example.getOredCriteria();
    }


    public void limit(long offset, int size) {
        this.limit = Limit.of(offset, size);
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }
}
