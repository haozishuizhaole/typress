package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext;

import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ConfigPOExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.base.Limit;

/**
 * @author chenzhihao
 * @date 2023-09-15 15:46
 */
public class ConfigPOExtExample extends ConfigPOExample {

    private Limit limit;

    public ConfigPOExtExample() {
    }

    public ConfigPOExtExample(ConfigPOExample example) {
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