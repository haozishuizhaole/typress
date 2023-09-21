package cc.chenzhihao.typress.core.business.usecase;

import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;

/**
 * 文章用例
 *
 * @author chenzhihao
 * @date 2023-09-20 20:10
 */
public interface ArticleUseCases {

    /**
     * 获取文章信息
     *
     * @param articleId 文章ID
     * @return 返回结果
     */
    GetArticleInfoResponseDTO getArticleInfo(Long articleId);
}
