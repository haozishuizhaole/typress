package cc.chenzhihao.typress.core.domain.config.vo;

import cc.chenzhihao.typress.commons.model.vo.Identity;
import lombok.Getter;

/**
 * 配置Key
 *
 * @author chenzhihao
 * @date 2023-12-23 23:05
 */
@Getter
public enum ConfigKey implements Identity<ConfigKey> {

    /**
     * 站点信息
     */
    SITE_INFO(SiteInfoConfigValue.class);

    /**
     * 配置值类型
     */
    private final Class<?> configValueType;

    ConfigKey(Class<?> configValueType) {
        this.configValueType = configValueType;
    }

    @Override
    public ConfigKey getId() {
        return this;
    }
}
