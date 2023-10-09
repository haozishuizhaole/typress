package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.service.administer.AdministerService;
import cc.chenzhihao.typress.core.domain.service.authenticate.handler.impl.AdministerPasswordAuthenticateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 认证处理器配置
 *
 * @author chenzhihao
 * @date 2023-10-09 15:57
 */
@Configuration
public class AuthenticateHandlerConfiguration {

    /**
     * 管理员密码认证处理器
     */
    @Bean
    public AdministerPasswordAuthenticateHandler administerPasswordAuthenticateHandler(AdministerService administerService) {
        return new AdministerPasswordAuthenticateHandler(administerService);
    }

}
