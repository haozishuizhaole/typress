package cc.chenzhihao.typress.core.service.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取站点配置 响应
 *
 * @author chenzhihao
 * @date 2024-01-11 16:21
 */
@Data
public class GetSiteInfoConfigResponseDTO implements Serializable {

    private static final long serialVersionUID = -5596795067621900831L;

    /**
     * 站点名称
     */
    private String siteName;
}
