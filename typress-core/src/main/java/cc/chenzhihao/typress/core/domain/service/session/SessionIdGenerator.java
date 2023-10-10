package cc.chenzhihao.typress.core.domain.service.session;

import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;

/**
 * 会话ID生成器
 *
 * @author chenzhihao
 * @date 2023-10-08 17:28
 */
public interface SessionIdGenerator {

    /**
     * 生成会话ID
     *
     * @return 会话ID
     */
    SessionId generate();

    /**
     * 基于会话字符串
     *
     * @param sessionId 会话ID字符串
     * @return 会话ID
     */
    SessionId generate(String sessionId);

}
