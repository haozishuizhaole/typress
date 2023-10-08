package cc.chenzhihao.typress.core.domain.exception;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.service.result.ErrorCode;

/**
 * 会话未认证
 *
 * @author chenzhihao
 * @date 2023-10-08 17:53
 */
public class UnAuthenticationSessionException extends BusinessException {

    private static final long serialVersionUID = -9038943903583714966L;

    public UnAuthenticationSessionException() {
        super(ErrorCode.UN_AUTHENTICATION);
    }
}
