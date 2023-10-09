package cc.chenzhihao.typress.core.domain.service.authenticate;

import cc.chenzhihao.typress.core.domain.exception.AuthenticateException;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;

/**
 * 认证业务接口
 *
 * @author chenzhihao
 * @date 2023-10-09 13:53
 */
public interface AuthenticateService {

    /**
     * 认证
     *
     * @param certification 凭证信息
     * @return 用户
     * @throws AuthenticateException 认证失败时抛出
     */
    User authenticate(Certification certification) throws AuthenticateException;

}
