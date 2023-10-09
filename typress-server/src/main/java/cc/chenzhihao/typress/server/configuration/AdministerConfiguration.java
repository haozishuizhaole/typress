package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.domain.service.administer.AdministerService;
import cc.chenzhihao.typress.core.domain.service.administer.impl.ConfigAdministerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 管理员组件配置
 *
 * @author chenzhihao
 * @date 2023-10-09 15:54
 */
@Configuration
public class AdministerConfiguration {

    /**
     * 基于配置的管理员业务接口
     */
    @Bean
    @Primary
    public AdministerService configAdministerService(ConfigRepository configRepository) {
        return new ConfigAdministerServiceImpl(configRepository);
    }

}
