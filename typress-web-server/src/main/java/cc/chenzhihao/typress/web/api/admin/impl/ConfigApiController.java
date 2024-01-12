package cc.chenzhihao.typress.web.api.admin.impl;

import cc.chenzhihao.typress.commons.model.dto.Result;
import cc.chenzhihao.typress.core.service.dto.req.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCase;
import cc.chenzhihao.typress.web.api.admin.ConfigApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Config API 控制器
 *
 * @author chenzhihao
 * @date 2024-01-11 17:23
 */
@RestController
@RequestMapping("/admin/config")
public class ConfigApiController implements ConfigApi {

    @Resource
    private ConfigUseCase configUseCase;


    @Override
    @PostMapping("/getSiteInfo")
    public Result<GetSiteInfoConfigResponseDTO> getSiteInfo() throws Exception {
        return Result.success(configUseCase.getSiteInfoConfig());
    }

    @Override
    @PostMapping("/setSiteInfo")
    public Result<?> setSiteInfo(@RequestBody SetSiteInfoConfigRequestDTO req) throws Exception {
        configUseCase.setSiteInfoConfig(req);
        return Result.success();
    }
}
