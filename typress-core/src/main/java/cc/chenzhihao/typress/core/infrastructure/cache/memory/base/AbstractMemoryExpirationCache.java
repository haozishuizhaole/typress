package cc.chenzhihao.typress.core.infrastructure.cache.memory.base;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.base.Cache;
import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Identity;
import com.google.common.cache.CacheBuilder;
import org.apache.ibatis.cache.CacheException;

import java.time.Duration;

/**
 * 抽象基于内存的可过期缓存实现
 *
 * @author chenzhihao
 * @date 2023-10-08 15:55
 */
public class AbstractMemoryExpirationCache<K extends Identity<?>, V extends Entity<K>> implements Cache<K, V> {

    /**
     * 缓存过期时间
     */
    protected final Duration expireTime;

    /**
     * 缓存
     */
    protected final com.google.common.cache.Cache<K, V> cache;

    public AbstractMemoryExpirationCache(Duration expireTime) {
        this.expireTime = expireTime;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expireTime)
                .build();
    }

    @Override
    public void set(K key, V value) throws CacheException {
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        cache.put(key, value);
    }

    @Override
    public V get(K key) throws CacheException {
        return cache.getIfPresent(key);
    }

    @Override
    public V remove(K key) throws CacheException {
        V cacheValue = cache.getIfPresent(key);
        cache.invalidate(key);
        return cacheValue;
    }

}