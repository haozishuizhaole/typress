package cc.chenzhihao.typress.core.infrastructure.cache.memory.base;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.base.Cache;
import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Identity;
import org.apache.ibatis.cache.CacheException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象内存缓存实现
 *
 * @author chenzhihao
 * @date 2023-10-08 15:51
 */
public abstract class AbstractMemoryCache<K extends Identity<?>, V extends Entity<K>> implements Cache<K, V> {

    protected final Map<K, V> cache = new ConcurrentHashMap<>();

    @Override
    public void set(K key, V value) throws CacheException {
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        cache.put(key, value);
    }

    @Override
    public V get(K key) throws CacheException {
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        return cache.get(key);
    }

    @Override
    public V remove(K key) throws CacheException {
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        return cache.remove(key);
    }

}
