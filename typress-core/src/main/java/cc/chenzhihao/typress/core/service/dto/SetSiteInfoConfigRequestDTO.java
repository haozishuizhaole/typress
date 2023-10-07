package cc.chenzhihao.typress.core.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 修改找点信息配置 请求
 *
 * @author chenzhihao
 * @date 2023-09-19 16:15
 */
@Data
public class SetSiteInfoConfigRequestDTO implements Serializable {

    private static final long serialVersionUID = 6725379621572881224L;

    /**
     * 站点名称
     */
    @NotBlank(message = "{config.siteinfo.sitename.notblank}")
    private String siteName;
}
