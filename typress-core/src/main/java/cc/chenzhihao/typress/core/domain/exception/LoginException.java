package cc.chenzhihao.typress.core.domain.exception;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.service.result.Error;
import lombok.NonNull;

/**
 * 登录异常
 *
 * @author chenzhihao
 * @date 2023-10-09 14:09
 */
public class LoginException extends BusinessException {

    private static final long serialVersionUID = -7803440958418714469L;

    public LoginException(String errorMsg) {
        super(errorMsg);
    }

    public LoginException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public LoginException(@NonNull Error error) {
        super(error);
    }

    public LoginException(@NonNull Error error, String errorMsg) {
        super(error, errorMsg);
    }
}
