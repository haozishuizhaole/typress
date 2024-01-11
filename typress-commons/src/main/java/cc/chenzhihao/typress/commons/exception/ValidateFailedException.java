package cc.chenzhihao.typress.commons.exception;

import cc.chenzhihao.typress.commons.model.dto.IStatus;

/**
 * 验证失败
 *
 * @author chenzhihao
 * @date 2024-01-11 19:32
 */
public class ValidateFailedException extends BusinessException{

    private static final long serialVersionUID = -4964951121830857017L;

    public ValidateFailedException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ValidateFailedException(IStatus status) {
        super(status);
    }

    public ValidateFailedException(IStatus status, String errorMsg) {
        super(status, errorMsg);
    }
}
