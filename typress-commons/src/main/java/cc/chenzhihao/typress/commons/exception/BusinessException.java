package cc.chenzhihao.typress.commons.exception;

import cc.chenzhihao.typress.commons.dto.IStatus;
import lombok.Getter;

/**
 * 业务异常
 * <p>
 * 无需捕获，全局异常处理器统一处理
 *
 * @author chenzhihao
 * @date 2023-12-22 18:12
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -7870184012474782475L;

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误信息
     */
    private final String errorMsg;

    public BusinessException(String errorCode, String errorMsg) {
        super(String.join(":", errorCode, errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(IStatus status) {
        this(status.getCode(), status.getMsg());
    }

    public BusinessException(IStatus status, String errorMsg) {
        this(status.getCode(), errorMsg);
    }
}
