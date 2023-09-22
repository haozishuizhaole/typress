package cc.chenzhihao.typress.core.business.dto;

import cc.chenzhihao.typress.core.business.dto.base.PageResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查找文章 响应
 *
 * @author chenzhihao
 * @date 2023-09-21 19:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FindArticlesResponseDTO extends PageResponseDTO<FindArticlesResponseDTO.Article> {

    private static final long serialVersionUID = 2412262215857499159L;

    public FindArticlesResponseDTO() {
    }

    public FindArticlesResponseDTO(Long total, List<Article> list) {
        super(total, list);
    }


    @Data
    public static class Article implements Serializable {

        private static final long serialVersionUID = -4085152023662578713L;

        /**
         * 文章ID
         */
        private Long articleId;

        /**
         * 文章标题
         */
        private String articleTitle;

    }

}
