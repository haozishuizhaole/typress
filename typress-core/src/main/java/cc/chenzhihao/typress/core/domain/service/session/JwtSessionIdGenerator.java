package cc.chenzhihao.typress.core.domain.service.session;

import cc.chenzhihao.typress.core.domain.model.vo.session.JwtSessionId;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;

/**
 * 基于JWT的SessionID生成器
 *
 * @author chenzhihao
 * @date 2023-10-08 17:29
 */
public class JwtSessionIdGenerator implements SessionIdGenerator {

    @Override
    public SessionId generate() {
        return new JwtSessionId();
    }
}
