package cc.chenzhihao.typress.core.domain.service.authenticate.handler.impl;

import cc.chenzhihao.typress.core.domain.exception.AuthenticateException;
import cc.chenzhihao.typress.core.domain.model.entity.Administer;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.PasswordCertification;
import cc.chenzhihao.typress.core.domain.service.administer.AdministerService;
import cc.chenzhihao.typress.core.domain.service.authenticate.handler.AdministerAuthenticateHandler;
import cc.chenzhihao.typress.core.service.result.ErrorCode;

import java.util.Objects;

/**
 * 管理员密码认证处理器
 *
 * @author chenzhihao
 * @date 2023-10-09 14:43
 */
public class AdministerPasswordAuthenticateHandler implements AdministerAuthenticateHandler<PasswordCertification> {

    private final AdministerService administerService;

    public AdministerPasswordAuthenticateHandler(AdministerService administerService) {
        this.administerService = administerService;
    }

    @Override
    public Class<PasswordCertification> certificationType() {
        return PasswordCertification.class;
    }

    @Override
    public User authenticate(Certification certification) throws AuthenticateException {
        // 获取管理员信息
        Administer administer = administerService.getAdminister();

        // 管理员信息不存在
        if (Objects.isNull(administer)) {
            throw new AuthenticateException(ErrorCode.AUTHENTICATION_FAILED, "not config administer");
        }

        // 凭证类型转换
        PasswordCertification passwordCertification = (PasswordCertification) certification;

        // 凭证校验：密码错误
        if (!Objects.equals(passwordCertification.getPassword(), administer.getPassword())) {
            throw new AuthenticateException(ErrorCode.CERTIFICATE_VALIDATE_FAILED, "certification validate failed");
        }

        // 返回管理员信息
        return administer;
    }
}
