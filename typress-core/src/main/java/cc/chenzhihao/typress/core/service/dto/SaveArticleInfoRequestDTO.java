package cc.chenzhihao.typress.core.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 保存文章信息 请求
 *
 * @author chenzhihao
 * @date 2023-09-21 16:31
 */
@Data
public class SaveArticleInfoRequestDTO implements Serializable {

    private static final long serialVersionUID = 9173125461286732073L;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    @NotBlank(message = "${article.articleTitle.notBlank}")
    @Length(max = 20, message = "${article.articleTitle.maxLength}")
    private String articleTitle;

    /**
     * 文章内容（原始内容）
     */
    private String articleContent;
}
