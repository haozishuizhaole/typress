package cc.chenzhihao.typress.core.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 保存文章信息 请求
 *
 * @author chenzhihao
 * @date 2023-09-21 16:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveArticleInfoResponseDTO implements Serializable {

    private static final long serialVersionUID = 4332201798328213331L;

    /**
     * 文章ID
     */
    private Long articleId;
}
