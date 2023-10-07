package cc.chenzhihao.typress.core.domain.exception.base;

import cc.chenzhihao.typress.core.service.result.Error;
import cc.chenzhihao.typress.core.service.result.ErrorCode;
import lombok.NonNull;

/**
 * 业务异常，无需主动捕获
 *
 * @author chenzhihao
 * @date 2023-09-27 15:44
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 8453096518573934295L;

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误信息
     */
    private final String errorMsg;

    public BusinessException(String errorMsg) {
        this(ErrorCode.PARAM_ERROR.getCode(), errorMsg);
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(String.join(":", errorCode, errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(@NonNull Error error) {
        this(error.getCode(), error.getMsg());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
