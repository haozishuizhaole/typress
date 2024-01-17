package cc.chenzhihao.typress.core.service.usecase;

import cc.chenzhihao.typress.commons.exception.ServiceException;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.core.service.dto.resp.GetArticleOriginalInfoByIDResponseDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetArticleRenderedInfoByIDResponseDTO;

/**
 * 文章用例
 *
 * @author chenzhihao
 * @date 2024-01-16 14:54
 */
public interface ArticleUseCase {

    /**
     * 根据ID获取原始文章信息
     */
    GetArticleOriginalInfoByIDResponseDTO getArticleOriginalInfoByID(ArticleID id) throws ServiceException;

    /**
     * 根据ID获取渲染后的文章信息
     */
    GetArticleRenderedInfoByIDResponseDTO getArticleRenderedInfoByID(ArticleID id) throws ServiceException;

}
