package cc.chenzhihao.typress.server.component.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Typress 配置
 *
 * @author chenzhihao
 * @date 2023-12-20 20:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "typress")
public class TypressConfig {

    private DataPath dataPath;

    /**
     * 数据空间
     */
    @Data
    public static class DataPath {
        /**
         * 根目录
         */
        private String rootDir;

        /**
         * 数据库目录
         */
        private String databaseDir;

        /**
         * 日志目录
         */
        private String logsDir;
    }
}
