package cc.chenzhihao.typress.core.domain.repository.base;

import cc.chenzhihao.typress.core.domain.condition.base.Condition;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Identity;

import java.util.List;

/**
 * 资源库接口
 *
 * @author chenzhihao
 * @date 2023-09-15 14:04
 */
public interface Repository<I extends Identity<?>, E extends Entity<I>, C extends Condition> {

    /**
     * 保存实体
     *
     * @param entity 实体
     * @throws RepositoryException 资源库异常
     */
    default void save(E entity) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 删除实体
     *
     * @param id ID
     * @throws RepositoryException 资源库异常
     */
    default void delete(I id) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 根据ID获取实体
     *
     * @param id ID
     * @return 实体
     * @throws RepositoryException 资源库异常
     */
    default E getById(I id) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * ID对应的实体是否存在
     *
     * @param id ID
     * @return true 存在，false 不存在
     * @throws RepositoryException 资源库异常
     */
    default boolean contains(I id) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 查询符合条件的实体条数
     *
     * @param condition 查询小件
     * @return 符合条件的实体条数
     * @throws RepositoryException 资源库异常
     */
    default long countByCondition(C condition) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }

    /**
     * 查询图和条件的实体
     *
     * @param condition 查询条件
     * @return 符合条件的实体
     * @throws RepositoryException 资源库异常
     */
    default List<E> getByCondition(C condition) throws RepositoryException {
        throw new UnsupportedOperationException("not implements");
    }
}