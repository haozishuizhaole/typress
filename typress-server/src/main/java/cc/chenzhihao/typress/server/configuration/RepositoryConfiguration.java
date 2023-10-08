package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.SessionCache;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.repository.ArticleRepository;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.domain.repository.SessionRepository;
import cc.chenzhihao.typress.core.repository.impl.DefaultArticleRepository;
import cc.chenzhihao.typress.core.repository.impl.DefaultConfigRepository;
import cc.chenzhihao.typress.core.repository.impl.DefaultSessionRepository;
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

    /**
     * 配置资源库
     */
    @Bean
    public ConfigRepository configRepository(ConfigPersistence configPersistence) {
        return new DefaultConfigRepository(configPersistence);
    }

    /**
     * 文章资源库
     */
    @Bean
    public ArticleRepository articleRepository(ArticlePersistence articlePersistence) {
        return new DefaultArticleRepository(articlePersistence);
    }

    /**
     * 会话资源库
     */
    @Bean
    public SessionRepository sessionRepository(SessionCache sessionCache) {
        return new DefaultSessionRepository(sessionCache);
    }
}
