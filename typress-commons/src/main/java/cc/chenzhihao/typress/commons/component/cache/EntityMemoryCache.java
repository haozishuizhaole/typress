package cc.chenzhihao.typress.commons.component.cache;

import cc.chenzhihao.typress.commons.model.entity.Entity;
import cc.chenzhihao.typress.commons.model.vo.Identity;

/**
 * 基于内存的实体缓存
 *
 * @author chenzhihao
 * @date 2023-12-23 20:15
 */
public abstract class EntityMemoryCache<K extends Identity<?>, V extends Entity<K>> extends MemoryCache<K, V> {
}
