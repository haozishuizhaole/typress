package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ArticlePersistence;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.infrastructure.persistence.mysql.MySQLConfigPersistence;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.SqLiteArticlePersistence;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.SqLiteConfigPersistence;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext.ArticlePOExtMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 持久层配置
 *
 * @author chenzhihao
 * @date 2023-09-18 19:49
 */
@Configuration
public class PersistenceConfiguration {

    @Bean(name = "configPersistence")
    @ConditionalOnProperty(prefix = "typress.persistence", name = "type", havingValue = "sqlite")
    public ConfigPersistence sqliteConfigPersistence(cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext.ConfigPOExtMapper configPOExtMapper) {
        return new SqLiteConfigPersistence(configPOExtMapper);
    }

    @Bean(name = "configPersistence")
    @ConditionalOnProperty(prefix = "typress.persistence", name = "type", havingValue = "mysql")
    public ConfigPersistence mysqlConfigPersistence() {
        return new MySQLConfigPersistence();
    }

    @Bean(name = "articlePersistence")
    @ConditionalOnProperty(prefix = "typress.persistence", name = "type", havingValue = "sqlite")
    public ArticlePersistence sqliteArticlePersistence(ArticlePOExtMapper articlePOExtMapper) {
        return new SqLiteArticlePersistence(articlePOExtMapper);
    }
}
