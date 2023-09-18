package cc.chenzhihao.typress.core.domain.exception.base;

/**
 * 持久层异常
 *
 * @author chenzhihao
 * @date 2023-09-15 14:26
 */
public class PersistenceException extends Exception{

    private static final long serialVersionUID = 972979047652256232L;

    public PersistenceException() {
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
