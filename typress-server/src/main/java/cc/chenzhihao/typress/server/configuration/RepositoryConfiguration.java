package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.repository.impl.DefaultArticleRepository;
import cc.chenzhihao.typress.core.repository.impl.DefaultConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 资源库配置
 *
 * @author chenzhihao
 * @date 2023-09-18 20:28
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    public ConfigRepository configRepository(ConfigPersistence configPersistence) {
        return new DefaultConfigRepository(configPersistence);
    }

    @Bean
    public ArticleRepository articleRepository(ArticlePersistence articlePersistence) {
        return new DefaultArticleRepository(articlePersistence);
    }
}
