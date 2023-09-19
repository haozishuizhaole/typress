package cc.chenzhihao.typress.core.business.usecase;

import cc.chenzhihao.typress.core.business.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SetSiteInfoConfigRequestDTO;

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
    GetSiteInfoConfigResponseDTO getSiteInfoConfig();

    /**
     * 修改站点信息配置
     *
     * @param request 站点信息
     */
    void setSiteInfoConfig(SetSiteInfoConfigRequestDTO request);
}
