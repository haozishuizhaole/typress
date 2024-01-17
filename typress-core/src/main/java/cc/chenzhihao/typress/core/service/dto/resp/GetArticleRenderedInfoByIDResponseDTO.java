package cc.chenzhihao.typress.core.service.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据ID获取文章 响应
 *
 * @author chenzhihao
 * @date 2024-01-16 15:00
 */
@Data
public class GetArticleRenderedInfoByIDResponseDTO implements Serializable {

    private static final long serialVersionUID = 3709920276892586662L;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 最后更新时间
     */
    private Long updateTime;
}
