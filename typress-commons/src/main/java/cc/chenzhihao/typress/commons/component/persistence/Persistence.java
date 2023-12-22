package cc.chenzhihao.typress.commons.component.persistence;


import cc.chenzhihao.typress.commons.component.condition.Condition;
import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.commons.model.entity.Entity;
import cc.chenzhihao.typress.commons.model.vo.Identity;

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
    default void create(E entity) throws PersistenceException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 按条件修改实体，字段可选
     *
     * @param entityData 新数据，不为null的字段将会被更新
     * @param condition  条件
     * @return 受影响的记录条数
     * @throws PersistenceException 持久化层操作失败
     */
    default int updateByConditionSelective(E entityData, C condition) throws PersistenceException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 查找符合条件的实体
     *
     * @param condition 条件
     * @return 实体列表
     * @throws PersistenceException 持久化层操作失败
     */
    default List<E> findByCondition(C condition) throws PersistenceException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 查询符合条件的实体条数
     *
     * @param condition 条件
     * @return 符合条件的实体数
     * @throws PersistenceException 持久化层操作失败
     */
    default long countByCondition(C condition) throws PersistenceException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 根据实体ID删除实体
     *
     * @param identity 实体ID
     * @throws PersistenceException 持久化层操作失败
     */
    default void delete(I identity) throws PersistenceException {
        throw new UnsupportedOperationException("not implements");
    }
}
