package cc.chenzhihao.typress.core.domain.exception.base;

/**
 * 服务层异常
 *
 * @author chenzhihao
 * @date 2023-09-19 13:57
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 7072964343534481610L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
