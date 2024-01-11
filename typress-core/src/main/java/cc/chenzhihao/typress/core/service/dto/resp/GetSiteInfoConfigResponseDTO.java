package cc.chenzhihao.typress.core.service.dto.resp;

import lombok.Data;

/**
 * 获取站点配置 用例响应
 *
 * @author chenzhihao
 * @date 2024-01-11 16:21
 */
@Data
public class GetSiteInfoConfigResponseDTO {

    /**
     * 站点名称
     */
    private String siteName;
}
