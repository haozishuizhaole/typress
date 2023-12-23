package cc.chenzhihao.typress.web.configuration;

import cc.chenzhihao.typress.web.config.WebConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;

/**
 * Web 配置
 *
 * @author chenzhihao
 * @date 2023-12-23 14:50
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    private WebConfig webConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // // 程序初始化拦截器
        // registry.addInterceptor(new InitializeInterceptor());
        // // 请求全链路跟踪拦截器
        // registry.addInterceptor(new TraceInterceptor());
        // // 用户会话拦截器
        // registry.addInterceptor(new SessionInterceptor(sessionService, sessionIdGenerator));
        //
        // // 权限拦截器
        // Optional.ofNullable(webConfig.getPermission()).ifPresent(permissionConfig -> {
        //     if (ArrayUtils.isEmpty(permissionConfig.getPathPatterns())) {
        //         return;
        //     }
        //     registry.addInterceptor(new PermissionInterceptor())
        //             .addPathPatterns(permissionConfig.getPathPatterns())
        //             .excludePathPatterns(permissionConfig.getExcludePathPatterns());
        // });
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        Optional.ofNullable(webConfig.getCors()).ifPresent(corsConfig -> Arrays.stream(corsConfig.getMappings()).forEach(mapping -> {
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

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }

}
