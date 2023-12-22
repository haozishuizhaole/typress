package cc.chenzhihao.typress.commons.exception;

/**
 * 服务层异常
 *
 * @author chenzhihao
 * @date 2023-12-22 18:12
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
