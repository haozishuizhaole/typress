package cc.chenzhihao.typress.core.domain.exception.base;

/**
 * 校验失败异常
 *
 * @author chenzhihao
 * @date 2023-09-19 17:02
 */
public class ValidateFailedException extends RuntimeException {

    private static final long serialVersionUID = 8617453270618870677L;

    public ValidateFailedException() {
    }

    public ValidateFailedException(String message) {
        super(message);
    }

    public ValidateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateFailedException(Throwable cause) {
        super(cause);
    }

    public ValidateFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
