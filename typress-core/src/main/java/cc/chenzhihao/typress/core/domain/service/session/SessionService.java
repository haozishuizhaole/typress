package cc.chenzhihao.typress.core.domain.service.session;

import cc.chenzhihao.typress.core.domain.exception.LoginException;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.session.LoginOptions;

/**
 * 会话业务接口
 *
 * @author chenzhihao
 * @date 2023-10-09 13:57
 */
public interface SessionService {

    /**
     * 登录
     *
     * @param user 身份信息
     * @param options      登录选项
     * @return 会话
     * @throws LoginException 登录失败异常
     */
    Session login(User user, LoginOptions options) throws LoginException;

}
