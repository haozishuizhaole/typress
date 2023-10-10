package cc.chenzhihao.typress.core.domain.service.session.impl;

import cc.chenzhihao.typress.core.domain.exception.LoginException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.session.LoginOptions;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionData;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.domain.repository.SessionRepository;
import cc.chenzhihao.typress.core.domain.service.session.SessionFactory;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import lombok.NonNull;

/**
 * 会话业务接口实现
 *
 * @author chenzhihao
 * @date 2023-10-09 20:19
 */
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    private final SessionFactory sessionFactory;

    public SessionServiceImpl(SessionRepository sessionRepository, SessionFactory sessionFactory) {
        this.sessionRepository = sessionRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSessionById(@NonNull SessionId sessionId) {
        try {
            return sessionRepository.getById(sessionId);
        } catch (RepositoryException e) {
            throw new RuntimeException("get session by sessionId from repository failed.", e);
        }
    }

    @Override
    public Session login(@NonNull User user, @NonNull LoginOptions options) throws LoginException {
        // 创建会话
        Session session = sessionFactory.newSession(new SessionData());

        // 存储会话
        try {
            sessionRepository.save(session);
        } catch (RepositoryException e) {
            throw new RuntimeException("session login save session to repository failed.", e);
        }

        // 返回会话
        return session;
    }
}
