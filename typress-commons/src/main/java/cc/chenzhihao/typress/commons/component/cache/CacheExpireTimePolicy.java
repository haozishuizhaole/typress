package cc.chenzhihao.typress.commons.component.cache;

/**
 * 缓存过期时间策略
 *
 * @author chenzhihao
 * @date 2023-12-23 19:48
 */
public enum CacheExpireTimePolicy {

    /**
     * 写入后开始计算过期时间
     */
    EXPIRE_AFTER_WRITE,

    /**
     * 每次访问重置过期时间
     */
    EXPIRE_AFTER_ACCESS,
}
