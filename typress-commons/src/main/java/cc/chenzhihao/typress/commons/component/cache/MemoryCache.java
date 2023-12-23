package cc.chenzhihao.typress.commons.component.cache;

import cc.chenzhihao.typress.commons.exception.CacheException;
import com.google.common.cache.CacheBuilder;

import java.time.Duration;
import java.util.Objects;

/**
 * 基于内存的缓存实现
 *
 * @author chenzhihao
 * @date 2023-12-23 19:50
 */
public class MemoryCache<K, V> implements Cache<K, V> {

    /**
     * 缓存
     */
    protected final com.google.common.cache.Cache<K, V> cache;

    /**
     * 构建无过期时间的缓存
     */
    public MemoryCache() {
        this(null, null);
    }

    /**
     * 带有过期时间的缓存，默认从写入开始计算过期时间
     *
     * @param expireTime 过期时间
     */
    public MemoryCache(Duration expireTime) {
        this(expireTime, CacheExpireTimePolicy.EXPIRE_AFTER_WRITE);
    }

    /**
     * 构造缓存，若expireTime和expireTimePolicy不为空则为带过期时间的缓存，否则不带过期时间
     *
     * @param expireTime       过期时间
     * @param expireTimePolicy 过期时间策略
     */
    public MemoryCache(Duration expireTime, CacheExpireTimePolicy expireTimePolicy) {
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();
        if (Objects.nonNull(expireTime) && Objects.nonNull(expireTimePolicy)) {
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
            throw new CacheException("cache key does not permit null");
        }
        return cache.asMap().containsKey(key);
    }
}
