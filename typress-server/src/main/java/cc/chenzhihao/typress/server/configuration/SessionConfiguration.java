package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.service.session.DefaultSessionFactory;
import cc.chenzhihao.typress.core.domain.service.session.JwtSessionIdGenerator;
import cc.chenzhihao.typress.core.domain.service.session.SessionFactory;
import cc.chenzhihao.typress.core.domain.service.session.SessionIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Session配置
 *
 * @author chenzhihao
 * @date 2023-10-08 18:09
 */
@Configuration
public class SessionConfiguration {

    /**
     * SessionId生成器
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JwtSessionIdGenerator();
    }

    /**
     * Session 工厂
     */
    @Bean
    public SessionFactory sessionFactory(SessionIdGenerator sessionIdGenerator) {
        return new DefaultSessionFactory(sessionIdGenerator);
    }
}
