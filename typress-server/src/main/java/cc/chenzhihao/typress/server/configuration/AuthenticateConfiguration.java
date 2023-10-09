package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;
import cc.chenzhihao.typress.core.domain.service.authenticate.AdministerAuthenticateService;
import cc.chenzhihao.typress.core.domain.service.authenticate.handler.AdministerAuthenticateHandler;
import cc.chenzhihao.typress.core.domain.service.authenticate.impl.AdministerAuthenticateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 认证配置
 *
 * @author chenzhihao
 * @date 2023-10-09 16:41
 */
@Configuration
public class AuthenticateConfiguration {

    /**
     * 管理员认证服务
     */
    @Bean
    public AdministerAuthenticateService administerAuthenticateService(List<AdministerAuthenticateHandler<? extends Certification>> handlers) {
        return new AdministerAuthenticateServiceImpl(handlers);
    }

}
