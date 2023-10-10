package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.service.session.SessionIdGenerator;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import cc.chenzhihao.typress.server.component.config.CorsConfig;
import cc.chenzhihao.typress.server.component.config.PermissionConfig;
import cc.chenzhihao.typress.server.component.interceptor.PermissionInterceptor;
import cc.chenzhihao.typress.server.component.interceptor.SessionInterceptor;
import cc.chenzhihao.typress.server.component.interceptor.TraceInterceptor;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Optional;

/**
 * Web配置
 *
 * @author chenzhihao
 * @date 2023-10-10 11:59
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "web")
public class WebConfiguration implements WebMvcConfigurer {

    private final SessionService sessionService;

    private final SessionIdGenerator sessionIdGenerator;

    /**
     * 跨域配置
     */
    private CorsConfig cors;

    /**
     * 权限配置
     */
    private PermissionConfig permission;

    public WebConfiguration(SessionService sessionService, SessionIdGenerator sessionIdGenerator) {
        this.sessionService = sessionService;
        this.sessionIdGenerator = sessionIdGenerator;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 请求全链路跟踪拦截器
        registry.addInterceptor(new TraceInterceptor());
        // 用户会话拦截器
        registry.addInterceptor(new SessionInterceptor(sessionService, sessionIdGenerator));

        // 权限拦截器
        Optional.ofNullable(permission).ifPresent(permissionConfig -> {
            if (ArrayUtils.isEmpty(permissionConfig.getPathPatterns())) {
                return;
            }
            registry.addInterceptor(new PermissionInterceptor())
                    .addPathPatterns(permissionConfig.getPathPatterns())
                    .excludePathPatterns(permissionConfig.getExcludePathPatterns());
        });
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        Optional.ofNullable(cors).ifPresent(corsConfig -> Arrays.stream(corsConfig.getMappings()).forEach(mapping -> {
            if (StringUtils.isBlank(mapping.getMappingPattern())) {
                throw new RuntimeException("cors mapping pattern can not be blank");
            }
            CorsConfiguration config = new CorsConfiguration();
            Optional.ofNullable(mapping.getAllowedOrigins()).ifPresent(e -> Arrays.stream(e).filter(StringUtils::isNotBlank).forEach(config::addAllowedOrigin));
            Optional.ofNullable(mapping.getAllowedOriginPatterns()).ifPresent(e -> Arrays.stream(e).filter(StringUtils::isNotBlank).forEach(config::addAllowedOriginPattern));
            Optional.ofNullable(mapping.getAllowedMethods()).ifPresent(e -> Arrays.stream(e).filter(StringUtils::isNotBlank).forEach(config::addAllowedMethod));
            Optional.ofNullable(mapping.getAllowedHeaders()).ifPresent(e -> Arrays.stream(e).filter(StringUtils::isNotBlank).forEach(config::addAllowedHeader));
            Optional.ofNullable(mapping.getAllowCredentials()).ifPresent(config::setAllowCredentials);
            Optional.ofNullable(mapping.getMaxAge()).ifPresent(config::setMaxAge);
            source.registerCorsConfiguration(mapping.getMappingPattern(), config);
        }));

        return new CorsFilter(source);

    }

}
