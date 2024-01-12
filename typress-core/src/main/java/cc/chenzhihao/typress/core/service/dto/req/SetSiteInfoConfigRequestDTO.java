package cc.chenzhihao.typress.core.service.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 设置站点信息 请求
 *
 * @author chenzhihao
 * @date 2024-01-11 20:17
 */
@Data
public class SetSiteInfoConfigRequestDTO implements Serializable {

    private static final long serialVersionUID = 7649568171326352055L;

    /**
     * 站点名称
     */
    @NotBlank(message = "{config.siteinfo.sitename.notblank}")
    private String siteName;
}
