package cc.chenzhihao.typress.core.domain.model.vo.config;

import lombok.Data;

import java.io.Serializable;

/**
 * 站点信息配置值
 *
 * @author chenzhihao
 * @date 2023-09-14 20:40
 */
@Data
public class SiteInfoConfigValue implements Serializable {

    private static final long serialVersionUID = -4936069937220073949L;

    /**
     * 站点名称
     */
    private String siteName;
}
