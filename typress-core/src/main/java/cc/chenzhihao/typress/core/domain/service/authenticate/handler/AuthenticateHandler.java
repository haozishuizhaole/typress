package cc.chenzhihao.typress.core.domain.service.authenticate.handler;

import cc.chenzhihao.typress.core.domain.exception.AuthenticateException;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;

/**
 * 认证处理器
 *
 * @author chenzhihao
 * @date 2023-10-09 14:30
 */
public interface AuthenticateHandler<T extends Certification> {

    /**
     * 可处理的认证信息类型
     *
     * @return 认证信息类型
     */
    Class<T> certificationType();

    /**
     * 执行认证
     *
     * @param certification 认证信息
     * @return 身份信息
     * @throws AuthenticateException 认证失败
     */
    User authenticate(Certification certification) throws AuthenticateException;

}
