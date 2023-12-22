package cc.chenzhihao.typress.commons.model.entity;


import cc.chenzhihao.typress.commons.model.vo.Identity;

import java.io.Serializable;

/**
 * 实体
 *
 * @author chenzhihao
 * @date 2023-09-14 20:47
 */
public interface Entity<I extends Identity<?>> extends Serializable {

    /**
     * 获取ID
     *
     * @return ID
     */
    I getId();

}