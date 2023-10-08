package cc.chenzhihao.typress.core.domain.repository;

import cc.chenzhihao.typress.core.domain.condition.SessionCondition;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.domain.repository.base.Repository;

/**
 * 会话资源库
 *
 * @author chenzhihao
 * @date 2023-10-08 15:40
 */
public interface SessionRepository extends Repository<SessionId, Session, SessionCondition> {
}
