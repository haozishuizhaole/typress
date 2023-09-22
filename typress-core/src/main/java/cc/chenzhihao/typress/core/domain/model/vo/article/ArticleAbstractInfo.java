package cc.chenzhihao.typress.core.domain.model.vo.article;

import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import lombok.Data;

import java.io.Serializable;

/**
 * 文章摘要信息
 *
 * @author chenzhihao
 * @date 2023-09-21 20:34
 */
@Data
public class ArticleAbstractInfo implements Serializable {

    private static final long serialVersionUID = 332059449124507548L;

    /**
     * 文章ID
     */
    private ArticleId articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 创建时间（毫秒时间戳）
     */
    private Timestamp createTime;

    /**
     * 修改时间（毫秒时间戳）
     */
    private Timestamp updateTime;
}
