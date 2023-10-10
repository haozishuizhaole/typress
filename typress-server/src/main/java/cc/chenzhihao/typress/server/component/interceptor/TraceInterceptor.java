package cc.chenzhihao.typress.server.component.interceptor;

import cc.chenzhihao.typress.core.domain.component.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全链路追踪拦截器
 *
 * @author chenzhihao
 * @date 2023-10-10 12:01
 */
@Slf4j
public class TraceInterceptor implements HandlerInterceptor {

    private static final String PARAM_TRACE_ID = "trace_id";

    private static final String LOG_TAG_REQUEST_IN = "http_request_in";

    private static final String LOG_TAG_REQUEST_OUT = "http_request_out";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 初始化Trace
        initTrace(request);

        // 记录请求开始日志
        logRequestIn(request);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 记录请求结束日志
        logRequestOut(request, response);

        // 清理资源
        clear();
    }

    /**
     * 记录请求
     *
     * @param request 请求
     */
    private void logRequestIn(HttpServletRequest request) {
        log.info("{}||url={}||method={}", LOG_TAG_REQUEST_IN, request.getRequestURI(), request.getMethod());
    }

    /**
     * 记录响应
     *
     * @param request  请求
     * @param response 响应
     */
    private void logRequestOut(HttpServletRequest request, HttpServletResponse response) {
        log.info("{}||url={}||method={}", LOG_TAG_REQUEST_OUT, request.getRequestURI(), request.getMethod());
    }

    /**
     * 初始化Trace
     *
     * @param request 请求
     */
    private void initTrace(HttpServletRequest request) {
        Context.setTraceId(StringUtils.defaultString(getTraceId(request), Context.getTraceId()));
    }

    /**
     * 获取TraceID，若没有则生成一个
     *
     * @param request 请求
     * @return TraceID
     */
    private String getTraceId(HttpServletRequest request) {
        return request.getHeader(PARAM_TRACE_ID);
    }

    /**
     * 清理资源
     */
    private void clear() {
        Context.clear();
    }
}
