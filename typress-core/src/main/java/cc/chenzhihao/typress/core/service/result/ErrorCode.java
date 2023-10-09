package cc.chenzhihao.typress.core.service.result;

/**
 * 错误码
 *
 * @author chenzhihao
 * @date 2023-09-18 20:51
 */

public enum ErrorCode implements Error {

    /**
     * 一切OK
     */
    SUCCESS("00000", "success"),

    /**
     * 用户端错误
     */
    CLIENT_ERROR("A0001", "caller error"),
    PARAM_ERROR("A0100", "parameter error"),
    UN_AUTHENTICATION("A0200", "un authentication"),
    AUTHENTICATION_FAILED("A0300", "authentication failed"),
    UN_SUPPORTED_AUTHENTICATE_CERTIFICATE_TYPE("A0301", "un supported authenticate certificate type"),
    CERTIFICATE_VALIDATE_FAILED("A0302", "certificate validate failed"),

    /**
     * 服务端错误
     */
    SYSTEM_ERROR("B0001", "system error"),

    /**
     * 第三方错误
     */
    THIRD_PART_ERROR("C0001", "third part error"),

    ;

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
