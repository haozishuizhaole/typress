package cc.chenzhihao.typress.core.domain.infrastructure.cache.base;

import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Identity;
import org.apache.ibatis.cache.CacheException;

/**
 * 缓存接口
 *
 * @author chenzhihao
 * @date 2023-10-08 15:46
 */
public interface Cache<K extends Identity<?>, V extends Entity<K>> {

    /**
     * 设置缓存
     *
     * @param key   键
     * @param value 值
     * @throws CacheException 缓存操作失败
     */
    void set(K key, V value) throws CacheException;

    /**
     * 获取缓存数据
     *
     * @param key 键
     * @return 值
     * @throws CacheException 缓存操作失败
     */
    V get(K key) throws CacheException;

    /**
     * 删除缓存
     *
     * @param key 键
     * @return 被删除的值
     * @throws CacheException 缓存操作失败
     */
    V remove(K key) throws CacheException;
}