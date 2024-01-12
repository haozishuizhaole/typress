package cc.chenzhihao.typress.web.api.admin;

import cc.chenzhihao.typress.commons.model.dto.Result;
import cc.chenzhihao.typress.core.service.dto.req.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteInfoConfigResponseDTO;

/**
 * Config API 接口
 *
 * @author chenzhihao
 * @date 2024-01-11 17:37
 */
public interface ConfigApi {

    /**
     * 获取站点信息
     */
    Result<GetSiteInfoConfigResponseDTO> getSiteInfo() throws Exception;

    /**
     * 设置站点信息
     */
    Result<?> setSiteInfo(SetSiteInfoConfigRequestDTO req) throws Exception;
}
