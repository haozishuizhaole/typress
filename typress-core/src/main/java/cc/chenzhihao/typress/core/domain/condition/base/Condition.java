package cc.chenzhihao.typress.core.domain.condition.base;

import lombok.Data;

/**
 * 查询条件
 *
 * @author chenzhihao
 * @date 2023-09-14 20:27
 */
@Data
public abstract class Condition {

    /**
     * 分页条件
     */
    private Pageable pageable;

}