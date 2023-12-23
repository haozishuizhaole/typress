package cc.chenzhihao.typress.commons.component.cache;

import cc.chenzhihao.typress.commons.model.entity.Entity;
import cc.chenzhihao.typress.commons.model.vo.Identity;

/**
 * 实体缓存
 *
 * @author chenzhihao
 * @date 2023-12-23 20:12
 */
public interface EntityCache<K extends Identity<?>, V extends Entity<K>> extends Cache<K, V> {
}
