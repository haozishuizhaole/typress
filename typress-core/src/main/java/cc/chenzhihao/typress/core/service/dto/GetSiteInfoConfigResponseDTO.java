package cc.chenzhihao.typress.core.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取站点信息配置 响应
 *
 * @author chenzhihao
 * @date 2023-09-19 13:44
 */
@Data
public class GetSiteInfoConfigResponseDTO implements Serializable {

    private static final long serialVersionUID = 6958128761612883730L;

    /**
     * 站点信息
     */
    private String siteName;
}
