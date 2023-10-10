package cc.chenzhihao.typress.server.component.interceptor;

import cc.chenzhihao.typress.core.domain.component.context.Context;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.domain.service.session.SessionIdGenerator;
import cc.chenzhihao.typress.core.domain.service.session.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

/**
 * 会话拦截器
 *
 * @author chenzhihao
 * @date 2023-10-09 20:56
 */
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    private static final String PARAM_SESSION_ID = "session_id";

    private final SessionService sessionService;

    private final SessionIdGenerator sessionIdGenerator;

    public SessionInterceptor(SessionService sessionService, SessionIdGenerator sessionIdGenerator) {
        this.sessionService = sessionService;
        this.sessionIdGenerator = sessionIdGenerator;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 初始化会话
        initSession(request);
        return true;
    }


    /**
     * 初始化会话
     *
     * @param request 请求
     */
    private void initSession(HttpServletRequest request) {
        Optional.ofNullable(getSession(request)).ifPresent(Context::setSession);
    }

    /**
     * 获取请求会话ID
     *
     * @param request 请求
     * @return Token
     */
    private SessionId getSessionId(HttpServletRequest request) {
        String sessionId = request.getHeader(PARAM_SESSION_ID);
        if (StringUtils.isBlank(sessionId)) {
            return null;
        }
        return sessionIdGenerator.generate(sessionId);
    }

    /**
     * 获取请求用户会话
     *
     * @param request 请求
     * @return 用户会话
     */
    private Session getSession(HttpServletRequest request) {
        SessionId sessionId = null;
        try {
            sessionId = getSessionId(request);
        } catch (Exception e) {
            log.warn("get session from request failed||msg={}", e.getMessage());
        }
        if (Objects.isNull(sessionId)) {
            return null;
        }
        return sessionService.getSessionById(sessionId);
    }

}