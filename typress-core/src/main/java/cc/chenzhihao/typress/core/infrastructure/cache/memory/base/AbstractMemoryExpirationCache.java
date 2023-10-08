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
public abstract class AbstractMemoryExpirationCache<K extends Identity<?>, V extends Entity<K>> implements Cache<K, V> {

    /**
     * 缓存过期时间
     */
    protected final Duration expireTime;

    /**
     * 缓存
     */
    protected final com.google.common.cache.Cache<K, V> cache;

    /**
     * 构造缓存，默认写入开始计算过期时间
     *
     * @param expireTime 过期时间
     */
    public AbstractMemoryExpirationCache(Duration expireTime) {
        this(expireTime, ExpireTimePolicy.EXPIRE_AFTER_WRITE);
    }

    /**
     * 构造缓存
     *
     * @param expireTime       过期时间
     * @param expireTimePolicy 过期时间策略
     */
    public AbstractMemoryExpirationCache(Duration expireTime, ExpireTimePolicy expireTimePolicy) {
        this.expireTime = expireTime;
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();

        switch (expireTimePolicy) {
            case EXPIRE_AFTER_WRITE:
                cacheBuilder.expireAfterWrite(expireTime);
                break;
            case EXPIRE_AFTER_ACCESS:
                cacheBuilder.expireAfterAccess(expireTime);
                break;
            default:
                throw new UnsupportedOperationException("unsupported expire time policy");
        }

        cache = cacheBuilder.build();
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
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        return cache.getIfPresent(key);
    }

    @Override
    public V remove(K key) throws CacheException {
        if (key == null) {
            throw new CacheException("cache key does not permit null");
        }
        V cacheValue = cache.getIfPresent(key);
        cache.invalidate(key);
        return cacheValue;
    }

    @Override
    public boolean contains(K key) throws CacheException {
        if (key == null) {
            return false;
        }
        return cache.asMap().containsKey(key);
    }
}