package cc.chenzhihao.typress.commons.model.dto;

/**
 * 状态接口
 *
 * @author chenzhihao
 * @date 2023-12-22 17:39
 */
public interface IStatus {

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    String getCode();

    /**
     * 获取状态信息
     *
     * @return 状态信息
     */
    String getMsg();
}
