package cc.chenzhihao.typress.server.component.config;

import lombok.Data;

/**
 * 权限配置
 *
 * @author chenzhihao
 * @date 2023-10-10 15:57
 */
@Data
public class PermissionConfig {

    /**
     * 需要鉴权的路径列表，支持通配符
     */
    private String[] pathPatterns;

    /**
     * 需要排除在外的路径列表，支持通配符
     */
    private String[] excludePathPatterns;
}
