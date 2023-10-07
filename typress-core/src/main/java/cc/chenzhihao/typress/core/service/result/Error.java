package cc.chenzhihao.typress.core.service.result;

/**
 * 通用错误码接口
 *
 * @author chenzhihao
 * @date 2023-09-18 20:50
 */
public interface Error {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMsg();

}
