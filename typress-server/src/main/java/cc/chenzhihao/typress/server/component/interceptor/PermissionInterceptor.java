package cc.chenzhihao.typress.server.component.interceptor;

import cc.chenzhihao.typress.core.domain.component.context.Context;
import cc.chenzhihao.typress.core.domain.exception.UnAuthenticationSessionException;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 权限拦截器
 *
 * @author chenzhihao
 * @date 2023-10-10 12:03
 */
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取用户会话
        Session session = getSession();

        // TODO @chenzhihao 2023/10/10 鉴权
        return true;
    }

    /**
     * 获取用户会话
     *
     * @return 用户会话
     */
    private Session getSession() {
        return Optional.ofNullable(Context.getSession()).orElseThrow(UnAuthenticationSessionException::new);
    }
}