package cc.chenzhihao.typress.core.domain.service.session;

import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionData;

/**
 * 默认Session工厂实现
 *
 * @author chenzhihao
 * @date 2023-10-08 17:27
 */
public class DefaultSessionFactory implements SessionFactory {

    private final SessionIdGenerator sessionIdGenerator;

    public DefaultSessionFactory(SessionIdGenerator sessionIdGenerator) {
        this.sessionIdGenerator = sessionIdGenerator;
    }

    @Override
    public Session newSession(SessionData sessionData) {
        return new Session(sessionIdGenerator.generate(), sessionData, new Timestamp());
    }
}
