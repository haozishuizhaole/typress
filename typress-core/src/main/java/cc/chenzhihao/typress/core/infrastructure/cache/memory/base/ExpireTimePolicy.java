package cc.chenzhihao.typress.core.infrastructure.cache.memory.base;

/**
 * 过期时间策略
 *
 * @author chenzhihao
 * @date 2023-10-08 16:10
 */
public enum ExpireTimePolicy {

    /**
     * 写入后开始计算过期时间
     */
    EXPIRE_AFTER_WRITE,

    /**
     * 每次访问重置过期时间
     */
    EXPIRE_AFTER_ACCESS,

}
