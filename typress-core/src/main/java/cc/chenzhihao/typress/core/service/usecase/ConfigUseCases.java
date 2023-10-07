package cc.chenzhihao.typress.core.service.usecase;

import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.service.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SetAdministratorConfigPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SetSiteInfoConfigRequestDTO;

/**
 * 配置用例
 *
 * @author chenzhihao
 * @date 2023-09-19 13:37
 */
public interface ConfigUseCases {

    /**
     * 获取站点信息配置
     *
     * @return 站点信息
     */
    GetSiteInfoConfigResponseDTO getSiteInfoConfig() throws ServiceException;

    /**
     * 修改站点信息配置
     *
     * @param request 站点信息
     */
    void setSiteInfoConfig(SetSiteInfoConfigRequestDTO request) throws ServiceException;

    /**
     * 修改管理员登录密码
     *
     * @param request 请求
     */
    void setAdministratorConfigPassword(SetAdministratorConfigPasswordRequestDTO request) throws ServiceException;
}
