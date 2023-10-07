package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SetAdministratorConfigPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.result.Result;
import cc.chenzhihao.typress.core.service.result.ResultUtil;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCases;
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
    public Result<GetSiteInfoConfigResponseDTO> getSiteInfoConfig() throws ServiceException {
        return ResultUtil.success(configUseCases.getSiteInfoConfig());
    }

    /**
     * 修改站点信息配置
     */
    @PostMapping("setSiteInfoConfig")
    public Result<?> setSiteInfoConfig(@RequestBody SetSiteInfoConfigRequestDTO request) throws ServiceException {
        configUseCases.setSiteInfoConfig(request);
        return ResultUtil.success();
    }

    /**
     * 修改管理员密码
     */
    @PostMapping("setAdministratorConfigPassword")
    public Result<?> setAdministratorConfigPassword(@RequestBody SetAdministratorConfigPasswordRequestDTO request) throws ServiceException {
        configUseCases.setAdministratorConfigPassword(request);
        return ResultUtil.success();
    }

}
