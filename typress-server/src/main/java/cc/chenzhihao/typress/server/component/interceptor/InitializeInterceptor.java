package cc.chenzhihao.typress.server.component.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 初始化拦截器
 * <p>
 * 这是所有请求的前置拦截，判断程序是否完成初始化，若未完成则拦截
 *
 * @author chenzhihao
 * @date 2023-12-19 20:41
 */
@Slf4j
public class InitializeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO @chenzhihao 2023/12/19 判断是否已经完成程序初始化
        return true;
    }
}
