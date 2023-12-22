package cc.chenzhihao.typress.commons.exception;

/**
 * 缓存层异常
 *
 * @author chenzhihao
 * @date 2023-12-22 18:12
 */
public class CacheException extends Exception{

    private static final long serialVersionUID = 4689476262828967355L;

    public CacheException() {
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }

    public CacheException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
