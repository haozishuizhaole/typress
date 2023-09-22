package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ext;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章摘要信息
 *
 * @author chenzhihao
 * @date 2023-09-21 20:01
 */
@Data
public class ArticleAbstractInfoExtPO implements Serializable {

    private static final long serialVersionUID = -3784472081020051934L;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 创建时间（毫秒时间戳）
     */
    private Long createTime;

    /**
     * 修改时间（毫秒时间戳）
     */
    private Long updateTime;

}
