package cc.chenzhihao.typress.server.configuration;

import cc.chenzhihao.typress.core.domain.service.session.SessionIdGenerator;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import cc.chenzhihao.typress.server.component.interceptor.PermissionInterceptor;
import cc.chenzhihao.typress.server.component.interceptor.SessionInterceptor;
import cc.chenzhihao.typress.server.component.interceptor.TraceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Web配置
 *
 * @author chenzhihao
 * @date 2023-10-10 11:59
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    private SessionService sessionService;

    @Resource
    private SessionIdGenerator sessionIdGenerator;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 请求全链路跟踪拦截器
        registry.addInterceptor(new TraceInterceptor());
        // 用户会话拦截器
        registry.addInterceptor(new SessionInterceptor(sessionService, sessionIdGenerator));
        // 权限拦截器
        registry.addInterceptor(new PermissionInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns(
                        "/admin/login/**",
                        "/admin/logout/**"
                );
    }
}
