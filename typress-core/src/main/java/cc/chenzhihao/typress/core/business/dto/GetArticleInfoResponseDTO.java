package cc.chenzhihao.typress.core.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取文章信息 响应
 *
 * @author chenzhihao
 * @date 2023-09-20 20:18
 */
@Data
public class GetArticleInfoResponseDTO implements Serializable {

    private static final long serialVersionUID = -3584744103734715060L;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容（已渲染）
     */
    private String articleContent;

    /**
     * 创建时间（毫秒时间戳）
     */
    private Long createTime;

    /**
     * 修改时间（毫秒时间戳）
     */
    private Long updateTime;
}
