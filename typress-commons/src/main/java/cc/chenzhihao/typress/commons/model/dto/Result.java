package cc.chenzhihao.typress.commons.model.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author chenzhihao
 * @date 2023-12-22 17:42
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6765843888836259115L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return StringUtils.equals(Status.SUCCESS.getCode(), this.code);
    }

    public static <T> Result<T> success() {
        return as(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), null);
    }

    public static <T> Result<T> success(T data) {
        return as(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return as(Status.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> as(IStatus status, T data) {
        return as(status.getCode(), status.getMsg(), data);
    }

    public static <T> Result<T> as(IStatus status) {
        return as(status.getCode(), status.getMsg(), null);
    }

    public static <T> Result<T> as(IStatus status, String msg) {
        return as(status.getCode(), msg, null);
    }

    public static <T> Result<T> as(String code, String msg) {
        return as(code, msg, null);
    }

    public static <T> Result<T> as(String code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

}

