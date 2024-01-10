package cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext;


import cc.chenzhihao.typress.infras.persistence.impl.sqlite.base.Limit;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ConfigPOExample;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Config条件查询扩展
 *
 * @author chenzhihao
 * @date 2023-12-29 17:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
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

}