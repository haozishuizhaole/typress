package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.business.dto.GetArticleInfoResponseDTO;
import cc.chenzhihao.typress.core.business.result.Result;
import cc.chenzhihao.typress.core.business.result.ResultUtil;
import cc.chenzhihao.typress.core.business.usecase.ArticleUseCases;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 获取文章信息
     */
    @PostMapping("getArticleInfo")
    public Result<GetArticleInfoResponseDTO> getArticleInfo(@RequestParam("articleId") Long articleId) {
        return ResultUtil.success(articleUseCases.getArticleInfo(articleId));
    }
}
