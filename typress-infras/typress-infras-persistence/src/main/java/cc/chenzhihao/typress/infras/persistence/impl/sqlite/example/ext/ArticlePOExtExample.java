package cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext;

import cc.chenzhihao.typress.infras.persistence.impl.sqlite.base.Limit;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ArticlePOExample;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Article 扩展查询条件
 *
 * @author chenzhihao
 * @date 2024-01-15 20:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
}
