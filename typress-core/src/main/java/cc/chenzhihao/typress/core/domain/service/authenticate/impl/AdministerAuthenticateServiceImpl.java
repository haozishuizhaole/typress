package cc.chenzhihao.typress.core.domain.service.authenticate.impl;

import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;
import cc.chenzhihao.typress.core.domain.service.authenticate.AbstractAuthenticateService;
import cc.chenzhihao.typress.core.domain.service.authenticate.AdministerAuthenticateService;
import cc.chenzhihao.typress.core.domain.service.authenticate.handler.AdministerAuthenticateHandler;

import java.util.List;

/**
 * 管理员认证业务接口实现
 *
 * @author chenzhihao
 * @date 2023-10-09 14:24
 */
public class AdministerAuthenticateServiceImpl extends AbstractAuthenticateService implements AdministerAuthenticateService {

    public AdministerAuthenticateServiceImpl(List<AdministerAuthenticateHandler<? extends Certification>> handlers) {
        super(handlers);
    }

}
