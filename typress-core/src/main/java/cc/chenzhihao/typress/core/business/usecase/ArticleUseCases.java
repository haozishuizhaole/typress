package cc.chenzhihao.typress.core.business.usecase;

import cc.chenzhihao.typress.core.business.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.business.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoResponseDTO;

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

    /**
     * 保存文章信息
     *
     * @param request 文章信息
     * @return 返回结果
     */
    SaveArticleInfoResponseDTO saveArticleInfo(SaveArticleInfoRequestDTO request);

    /**
     * 查找文章
     *
     * @param request 请求
     * @return 响应
     */
    FindArticlesResponseDTO findArticles(FindArticlesRequestDTO request);
}
