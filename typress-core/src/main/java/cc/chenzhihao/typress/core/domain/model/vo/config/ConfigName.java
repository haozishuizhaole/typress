package cc.chenzhihao.typress.core.domain.model.vo.config;

import cc.chenzhihao.typress.core.domain.model.vo.Identity;

/**
 * 配置名称
 *
 * @author chenzhihao
 * @date 2023-09-14 20:41
 */
public enum ConfigName implements Identity<ConfigName> {

    /**
     * 站点信息
     */
    SITE_INFO(SiteInfoConfigValue.class);

    /**
     * 配置值类型
     */
    private Class<?> valueType;

    ConfigName(Class<?> valueType) {
        this.valueType = valueType;
    }

    @Override
    public ConfigName getId() {
        return this;
    }

    public Class<?> getValueType() {
        return valueType;
    }
}
