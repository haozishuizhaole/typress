package cc.chenzhihao.typress.core.service.usecase;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordResponseDTO;

/**
 * 管理员用例
 *
 * @author chenzhihao
 * @date 2023-10-09 18:01
 */
public interface AdministerUseCases {

    /**
     * 通过密码登录
     *
     * @param request 请求
     * @return 响应
     * @throws ServiceException 异常
     */
    LoginByPasswordResponseDTO loginByPassword(LoginByPasswordRequestDTO request) throws ServiceException;

}
