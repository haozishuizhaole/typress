package cc.chenzhihao.typress.server.controller.admin;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordResponseDTO;
import cc.chenzhihao.typress.core.service.result.Result;
import cc.chenzhihao.typress.core.service.result.ResultUtil;
import cc.chenzhihao.typress.core.service.usecase.AdministerUseCases;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理端登录控制器
 *
 * @author chenzhihao
 * @date 2023-10-09 20:08
 */
@RestController
@RequestMapping("/admin/login")
public class AdminLoginController {

    @Resource
    private AdministerUseCases administerUseCases;

    /**
     * 使用密码登录
     */
    @PostMapping("loginByPassword")
    public Result<LoginByPasswordResponseDTO> loginByPassword(@RequestBody LoginByPasswordRequestDTO req) throws ServiceException {
        return ResultUtil.success(administerUseCases.loginByPassword(req));
    }

}
