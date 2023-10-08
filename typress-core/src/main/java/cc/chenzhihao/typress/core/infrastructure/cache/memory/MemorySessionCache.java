package cc.chenzhihao.typress.core.infrastructure.cache.memory;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.SessionCache;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.infrastructure.cache.memory.base.AbstractMemoryExpirationCache;

import java.time.Duration;

/**
 * 基于内存的会话缓存
 *
 * @author chenzhihao
 * @date 2023-10-08 15:58
 */
public class MemorySessionCache extends AbstractMemoryExpirationCache<SessionId, Session> implements SessionCache {

    public MemorySessionCache(Duration expireTime) {
        super(expireTime);
    }
}