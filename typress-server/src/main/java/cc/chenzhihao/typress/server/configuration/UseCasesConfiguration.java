package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.domain.service.authenticate.AdministerAuthenticateService;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import cc.chenzhihao.typress.core.service.usecase.AdministerUseCases;
import cc.chenzhihao.typress.core.service.usecase.ArticleUseCases;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCases;
import cc.chenzhihao.typress.core.service.usecase.impl.AdministerUseCasesImpl;
import cc.chenzhihao.typress.core.service.usecase.impl.ArticleUseCasesImpl;
import cc.chenzhihao.typress.core.service.usecase.impl.ConfigUseCasesImpl;
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

    /**
     * 配置用例
     */
    @Bean
    public ConfigUseCases configUseCases(ConfigRepository configRepository) {
        return new ConfigUseCasesImpl(configRepository);
    }

    /**
     * 文章用例
     */
    @Bean
    public ArticleUseCases articleUseCases(ArticleRepository articleRepository) {
        return new ArticleUseCasesImpl(articleRepository);
    }

    /**
     * 管理员用例
     */
    @Bean
    public AdministerUseCases administerLoginUseCases(AdministerAuthenticateService administerAuthenticateService, SessionService sessionService) {
        return new AdministerUseCasesImpl(administerAuthenticateService, sessionService);
    }
}
