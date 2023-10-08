package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.infrastructure.cache.SessionCache;
import cc.chenzhihao.typress.core.infrastructure.cache.memory.MemorySessionCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * 缓存配置
 *
 * @author chenzhihao
 * @date 2023-10-08 16:00
 */
@Configuration
public class CacheConfiguration {

    /**
     * 会话缓存：1h过期
     */
    @Bean
    public SessionCache sessionCache() {
        return new MemorySessionCache(Duration.ofHours(1));
    }
}
