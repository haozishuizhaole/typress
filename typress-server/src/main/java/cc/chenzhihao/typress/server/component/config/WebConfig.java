package cc.chenzhihao.typress.server.component.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Web 配置
 *
 * @author chenzhihao
 * @date 2023-12-20 20:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "web")
public class WebConfig {

    /**
     * 跨域配置
     */
    private CorsConfig cors;

    /**
     * 权限配置
     */
    private PermissionConfig permission;


    /**
     * 跨域配置
     */
    @Data
    public static class CorsConfig {

        /**
         * 跨域路径映射
         */
        private CorsMapping[] mappings;

        @Data
        public static class CorsMapping {
            private String mappingPattern;
            private String[] allowedOrigins;
            private String[] allowedOriginPatterns;
            private String[] allowedMethods;
            private String[] allowedHeaders;
            private String[] exposedHeaders;
            private Boolean allowCredentials;
            private Long maxAge;
        }

    }

    /**
     * 权限配置
     */
    @Data
    public static class PermissionConfig {

        /**
         * 需要鉴权的路径列表，支持通配符
         */
        private String[] pathPatterns;

        /**
         * 需要排除在外的路径列表，支持通配符
         */
        private String[] excludePathPatterns;
    }
}