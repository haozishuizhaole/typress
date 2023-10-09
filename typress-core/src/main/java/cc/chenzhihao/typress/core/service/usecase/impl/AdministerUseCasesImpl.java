package cc.chenzhihao.typress.core.service.usecase.impl;

import cc.chenzhihao.typress.core.domain.exception.AuthenticateException;
import cc.chenzhihao.typress.core.domain.exception.LoginException;
import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.PasswordCertification;
import cc.chenzhihao.typress.core.domain.model.vo.session.LoginOptions;
import cc.chenzhihao.typress.core.domain.service.authenticate.AdministerAuthenticateService;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import cc.chenzhihao.typress.core.service.convertor.SessionBusinessConvertor;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordResponseDTO;
import cc.chenzhihao.typress.core.service.usecase.AdministerUseCases;
import cc.chenzhihao.typress.core.utils.ValidateUtil;

/**
 * 管理员用例实现
 *
 * @author chenzhihao
 * @date 2023-10-09 19:09
 */
public class AdministerUseCasesImpl implements AdministerUseCases {

    private final AdministerAuthenticateService administerAuthenticateService;

    private final SessionService sessionService;

    public AdministerUseCasesImpl(AdministerAuthenticateService administerAuthenticateService, SessionService sessionService) {
        this.administerAuthenticateService = administerAuthenticateService;
        this.sessionService = sessionService;
    }

    @Override
    public LoginByPasswordResponseDTO loginByPassword(LoginByPasswordRequestDTO request) throws ServiceException {
        // 参数校验
        ValidateUtil.validate(request);

        // 数据转换
        PasswordCertification certification = SessionBusinessConvertor.convertLoginByPasswordRequestDTOToPasswordCertification(request);

        try {
            // 执行认证
            User user = administerAuthenticateService.authenticate(certification);
            // 执行登录
            Session session = sessionService.login(user, LoginOptions.getDefault());
            // 返回结果
            return SessionBusinessConvertor.convertSessionAndUserToLoginByPasswordResponseDTO(session, user);
        } catch (AuthenticateException | LoginException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("administer login by password use case cached unKnown exception.", e);
        }
    }
}
