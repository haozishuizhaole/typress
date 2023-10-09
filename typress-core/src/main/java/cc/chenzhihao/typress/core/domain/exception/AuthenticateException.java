package cc.chenzhihao.typress.core.domain.exception;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.service.result.Error;
import lombok.NonNull;

/**
 * 认证失败异常
 *
 * @author chenzhihao
 * @date 2023-10-09 13:55
 */
public class AuthenticateException extends BusinessException {
    
    private static final long serialVersionUID = -1668549485014283995L;

    public AuthenticateException(String errorMsg) {
        super(errorMsg);
    }

    public AuthenticateException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public AuthenticateException(@NonNull Error error) {
        super(error);
    }

    public AuthenticateException(@NonNull Error error, String errorMsg) {
        super(error, errorMsg);
    }
}
