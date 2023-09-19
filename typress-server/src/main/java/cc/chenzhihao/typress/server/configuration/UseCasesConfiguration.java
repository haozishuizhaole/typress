package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.business.usecase.ConfigUseCases;
import cc.chenzhihao.typress.core.business.usecase.impl.ConfigUseCasesImpl;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用例配置
 *
 * @author chenzhihao
 * @date 2023-09-19 13:48
 */
@Configuration
public class UseCasesConfiguration {

    @Bean
    public ConfigUseCases configUseCases(ConfigRepository configRepository) {
        return new ConfigUseCasesImpl(configRepository);
    }
}
