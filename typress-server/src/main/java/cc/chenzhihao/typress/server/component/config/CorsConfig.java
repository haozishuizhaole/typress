package cc.chenzhihao.typress.server.component.config;

import lombok.Data;

/**
 * 跨域配置
 *
 * @author chenzhihao
 * @date 2023-10-10 14:31
 */
@Data
public class CorsConfig {

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
