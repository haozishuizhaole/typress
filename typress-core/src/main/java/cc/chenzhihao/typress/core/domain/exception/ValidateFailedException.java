package cc.chenzhihao.typress.core.domain.exception;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.service.result.Error;
import lombok.NonNull;

/**
 * 校验失败异常
 *
 * @author chenzhihao
 * @date 2023-09-19 17:02
 */
public class ValidateFailedException extends BusinessException {

    private static final long serialVersionUID = 8617453270618870677L;

    public ValidateFailedException(String errorMsg) {
        super(errorMsg);
    }

    public ValidateFailedException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ValidateFailedException(@NonNull Error error) {
        super(error);
    }
}
