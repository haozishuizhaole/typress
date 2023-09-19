package cc.chenzhihao.typress.core.business.exception;

/**
 * 业务异常
 *
 * @author chenzhihao
 * @date 2023-09-19 13:57
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7072964343534481610L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
