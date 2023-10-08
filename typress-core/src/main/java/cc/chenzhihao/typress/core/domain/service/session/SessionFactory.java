package cc.chenzhihao.typress.core.domain.service.session;

import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionData;

/**
 * Session工厂
 *
 * @author chenzhihao
 * @date 2023-10-08 17:24
 */
public interface SessionFactory {

    /**
     * 创建一个会话
     *
     * @param sessionData 会话数据
     * @return 会话
     */
    Session newSession(SessionData sessionData);

}
