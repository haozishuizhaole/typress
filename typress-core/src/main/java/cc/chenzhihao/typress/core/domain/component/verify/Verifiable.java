package cc.chenzhihao.typress.core.domain.component.verify;

import cc.chenzhihao.typress.core.domain.exception.ValidateFailedException;

/**
 * 可验证的
 *
 * @author chenzhihao
 * @date 2023-09-19 16:53
 */
public interface Verifiable {

    /**
     * 校验
     *
     * @throws ValidateFailedException 校验失败抛出异常
     */
    void validate() throws ValidateFailedException;

}
