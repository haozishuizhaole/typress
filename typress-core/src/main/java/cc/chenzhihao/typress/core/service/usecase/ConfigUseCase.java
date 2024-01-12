package cc.chenzhihao.typress.core.service.usecase;

import cc.chenzhihao.typress.commons.exception.ServiceException;
import cc.chenzhihao.typress.core.service.dto.req.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteInfoConfigResponseDTO;

/**
 * Config用例
 *
 * @author chenzhihao
 * @date 2024-01-11 15:54
 */
public interface ConfigUseCase {

    /**
     * 获取站点配置
     */
    GetSiteInfoConfigResponseDTO getSiteInfoConfig() throws ServiceException;

    /**
     * 设置站点信息
     */
    void setSiteInfoConfig(SetSiteInfoConfigRequestDTO req) throws ServiceException;
}
