package cc.chenzhihao.typress.core.domain.infrastructure.persistence.base;

import cc.chenzhihao.typress.core.domain.condition.base.Condition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Identity;

import java.util.List;

/**
 * 持久层接口
 *
 * @author chenzhihao
 * @date 2023-09-15 14:26
 */
public interface Persistence<I extends Identity<?>, E extends Entity<I>, C extends Condition> {

    /**
     * 创建实体
     * <p>
     *
     * @throws PersistenceException 持久化层操作失败
     */
    void create(E entity) throws PersistenceException;

    /**
     * 按条件修改实体，字段可选
     *
     * @param entityData 新数据，不为null的字段将会被更新
     * @param condition  条件
     * @return 受影响的记录条数
     * @throws PersistenceException 持久化层操作失败
     */
    int updateByConditionSelective(E entityData, C condition) throws PersistenceException;

    /**
     * 查找符合条件的实体
     *
     * @param condition 条件
     * @return 实体列表
     * @throws PersistenceException 持久化层操作失败
     */
    List<E> findByCondition(C condition) throws PersistenceException;

    /**
     * 查询符合条件的实体条数
     *
     * @param condition 条件
     * @return 符合条件的实体数
     * @throws PersistenceException 持久化层操作失败
     */
    long countByCondition(C condition) throws PersistenceException;
}
