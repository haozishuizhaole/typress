package cc.chenzhihao.typress.core.domain.service.authenticate;

import cc.chenzhihao.typress.core.domain.exception.AuthenticateException;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.Certification;
import cc.chenzhihao.typress.core.domain.service.authenticate.handler.AuthenticateHandler;
import cc.chenzhihao.typress.core.service.result.ErrorCode;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 抽象认证业务接口
 *
 * @author chenzhihao
 * @date 2023-10-09 15:25
 */
public abstract class AbstractAuthenticateService implements AuthenticateService {

    /**
     * 认证处理器列表，映射不同凭证类型对应的处理器
     * <p>
     * 凭证类型 -> 认证处理器处理器
     */
    private final Map<Class<? extends Certification>, ? extends AuthenticateHandler<? extends Certification>> authenticateHandlers;

    public AbstractAuthenticateService(List<? extends AuthenticateHandler<? extends Certification>> handlers) {
        this.authenticateHandlers = handlers.stream().collect(Collectors.toMap(AuthenticateHandler::certificationType, e -> e));
    }

    @Override
    public User authenticate(@NonNull Certification certification) throws AuthenticateException {
        // 获取处理器
        AuthenticateHandler<? extends Certification> handler = getHandler(certification.getClass());
        if (Objects.isNull(handler)) {
            throw new AuthenticateException(ErrorCode.UN_SUPPORTED_AUTHENTICATE_CERTIFICATE_TYPE);
        }

        // 执行处理器
        return handler.authenticate(certification);
    }

    /**
     * 根据凭证类型获取处理器
     *
     * @param cls 凭证类型
     * @return 处理器
     */
    protected AuthenticateHandler<? extends Certification> getHandler(Class<? extends Certification> cls) {
        return authenticateHandlers.get(cls);
    }

}
