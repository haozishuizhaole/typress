package cc.chenzhihao.typress.core.model.config.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 站点信息配置值
 *
 * @author chenzhihao
 * @date 2023-12-23 23:06
 */
@Data
public class SiteInfoConfigValue implements Serializable {

    private static final long serialVersionUID = 5911945436841118572L;

    /**
     * 站点名称
     */
    private String siteName;
}
