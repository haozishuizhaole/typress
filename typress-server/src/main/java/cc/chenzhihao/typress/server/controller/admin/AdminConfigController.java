package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.business.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.business.result.Result;
import cc.chenzhihao.typress.core.business.result.ResultUtil;
import cc.chenzhihao.typress.core.business.usecase.ConfigUseCases;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理端：配置API
 *
 * @author chenzhihao
 * @date 2023-09-19 17:18
 */
@RestController
@RequestMapping("/admin/config")
public class AdminConfigController {

    @Resource
    private ConfigUseCases configUseCases;

    /**
     * 获取站点信息配置
     */
    @PostMapping("getSiteInfoConfig")
    public Result<GetSiteInfoConfigResponseDTO> getSiteInfoConfig() {
        return ResultUtil.success(configUseCases.getSiteInfoConfig());
    }

    /**
     * 修改站点信息配置
     */
    @PostMapping("setSiteInfoConfig")
    public Result<?> setSiteInfoConfig(@RequestBody SetSiteInfoConfigRequestDTO request) {
        configUseCases.setSiteInfoConfig(request);
        return ResultUtil.success();
    }

}
