package cc.chenzhihao.typress.core.domain.infrastructure.cache;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.base.Cache;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;

/**
 * 会话缓存
 *
 * @author chenzhihao
 * @date 2023-10-08 15:48
 */
public interface SessionCache extends Cache<SessionId, Session> {
}
