package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.business.dto.FindArticlesRequestDTO;
import cc.chenzhihao.typress.core.business.dto.FindArticlesResponseDTO;
import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoRequestDTO;
import cc.chenzhihao.typress.core.business.dto.SaveArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.result.Result;
import cc.chenzhihao.typress.core.business.result.ResultUtil;
import cc.chenzhihao.typress.core.business.usecase.ArticleUseCases;
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
    public Result<FindArticlesResponseDTO> findArticles(@RequestBody FindArticlesRequestDTO request) {
        return ResultUtil.success(articleUseCases.findArticles(request));
    }

    /**
     * 获取文章信息
     */
    @PostMapping("getArticleInfo")
    public Result<GetArticleInfoResponseDTO> getArticleInfo(@RequestParam("articleId") Long articleId) {
        return ResultUtil.success(articleUseCases.getArticleInfo(articleId));
    }

    /**
     * 保存文章信息
     */
    @PostMapping("saveArticleInfo")
    public Result<SaveArticleInfoResponseDTO> saveArticleInfo(@RequestBody SaveArticleInfoRequestDTO request) {
        return ResultUtil.success(articleUseCases.saveArticleInfo(request));
    }

    /**
     * 删除文章
     */
    @PostMapping("deleteArticle")
    public Result<?> deleteArticle(@RequestParam("articleId") Long articleId) {
        articleUseCases.deleteArticle(articleId);
        return ResultUtil.success();
    }
}
