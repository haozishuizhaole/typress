package cc.chenzhihao.typress.commons.model.vo;

import java.io.Serializable;

/**
 * 可标识的
 *
 * @author chenzhihao
 * @date 2023-09-14 20:44
 */
public interface Identity<T> extends Serializable {

    /**
     * 获取唯一标识
     *
     * @return 唯一标识
     */
    T getId();
}