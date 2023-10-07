package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.service.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.service.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SaveArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.service.result.Result;
import cc.chenzhihao.typress.core.service.result.ResultUtil;
import cc.chenzhihao.typress.core.service.usecase.ArticleUseCases;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理端：文章API
 *
 * @author chenzhihao
 * @date 2023-09-21 16:08
 */
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Resource
    private ArticleUseCases articleUseCases;

    /**
     * 查询文章列表
     */
    @PostMapping("findArticles")
    public Result<FindArticlesResponseDTO> findArticles(@RequestBody FindArticlesRequestDTO request) throws ServiceException {
        return ResultUtil.success(articleUseCases.findArticles(request));
    }

    /**
     * 获取文章信息
     */
    @PostMapping("getArticleInfo")
    public Result<GetArticleInfoResponseDTO> getArticleInfo(@RequestParam("articleId") Long articleId) throws ServiceException {
        return ResultUtil.success(articleUseCases.getArticleInfo(articleId));
    }

    /**
     * 保存文章信息
     */
    @PostMapping("saveArticleInfo")
    public Result<SaveArticleInfoResponseDTO> saveArticleInfo(@RequestBody SaveArticleInfoRequestDTO request) throws ServiceException {
        return ResultUtil.success(articleUseCases.saveArticleInfo(request));
    }

    /**
     * 删除文章
     */
    @PostMapping("deleteArticle")
    public Result<?> deleteArticle(@RequestParam("articleId") Long articleId) throws ServiceException {
        articleUseCases.deleteArticle(articleId);
        return ResultUtil.success();
    }
}
