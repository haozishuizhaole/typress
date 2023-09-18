package cc.chenzhihao.typress.core.business.result;

/**
 * @author chenzhihao
 * @date 2023-09-18 20:52
 */
public class ResultUtil {

    public static <T> Result<T> success() {
        return as(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMsg(), null);
    }

    public static <T> Result<T> success(T data) {
        return as(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> as(Error error) {
        return as(error.getCode(), error.getMsg(), null);
    }

    public static <T> Result<T> as(Error error, String msg) {
        return as(error.getCode(), msg, null);
    }

    public static <T> Result<T> as(String code, String msg) {
        return as(code, msg, null);
    }

    public static <T> Result<T> as(String code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }
}
