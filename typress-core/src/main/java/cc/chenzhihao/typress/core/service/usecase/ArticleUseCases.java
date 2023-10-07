package cc.chenzhihao.typress.core.service.usecase;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.service.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.service.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SaveArticleInfoResponseDTO;

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
    GetArticleInfoResponseDTO getArticleInfo(Long articleId) throws ServiceException;

    /**
     * 保存文章信息
     *
     * @param request 文章信息
     * @return 返回结果
     */
    SaveArticleInfoResponseDTO saveArticleInfo(SaveArticleInfoRequestDTO request) throws ServiceException;

    /**
     * 查找文章
     *
     * @param request 请求
     * @return 响应
     */
    FindArticlesResponseDTO findArticles(FindArticlesRequestDTO request) throws ServiceException;

    /**
     * 删除文章
     *
     * @param articleId 文章ID
     */
    void deleteArticle(Long articleId) throws ServiceException;
}
