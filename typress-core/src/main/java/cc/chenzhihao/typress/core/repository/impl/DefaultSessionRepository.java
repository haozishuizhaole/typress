package cc.chenzhihao.typress.core.repository.impl;

import cc.chenzhihao.typress.core.domain.exception.base.CacheException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.infrastructure.cache.SessionCache;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.domain.repository.SessionRepository;

/**
 * 默认会话资源库实现
 *
 * @author chenzhihao
 * @date 2023-10-08 16:26
 */
public class DefaultSessionRepository implements SessionRepository {

    private final SessionCache cache;

    public DefaultSessionRepository(SessionCache cache) {
        this.cache = cache;
    }

    @Override
    public void save(Session entity) throws RepositoryException {
        try {
            cache.set(entity.getSessionId(), entity);
        } catch (CacheException e) {
            throw new RepositoryException("session cache set failed");
        }
    }

    @Override
    public void delete(SessionId id) throws RepositoryException {
        try {
            cache.remove(id);
        } catch (CacheException e) {
            throw new RepositoryException("session cache remove failed");
        }
    }

    @Override
    public Session getById(SessionId id) throws RepositoryException {
        try {
            return cache.get(id);
        } catch (CacheException e) {
            throw new RepositoryException("session cache get failed");
        }
    }

    @Override
    public boolean contains(SessionId id) throws RepositoryException {
        try {
            return cache.contains(id);
        } catch (CacheException e) {
            throw new RepositoryException("session cache contains failed", e);
        }
    }
}
