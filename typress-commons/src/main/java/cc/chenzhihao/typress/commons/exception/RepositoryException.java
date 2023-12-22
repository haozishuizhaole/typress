package cc.chenzhihao.typress.commons.exception;

/**
 * 资源库异常
 *
 * @author chenzhihao
 * @date 2023-12-22 18:12
 */
public class RepositoryException extends Exception {

    private static final long serialVersionUID = 1217494145741948487L;

    public RepositoryException() {
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}