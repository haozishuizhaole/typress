package cc.chenzhihao.typress.bootstrap.config;

import cc.chenzhihao.typress.core.component.config.TypressConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基于Spring的TypressConfig
 *
 * @author chenzhihao
 * @date 2024-01-02 16:29
 */
@Data
@Component
@ConfigurationProperties(prefix = "typress")
public class SpringTypressConfig implements TypressConfig {

}
