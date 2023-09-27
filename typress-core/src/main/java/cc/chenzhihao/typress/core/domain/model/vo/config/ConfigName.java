package cc.chenzhihao.typress.core.domain.model.vo.config;

import cc.chenzhihao.typress.core.domain.model.vo.Identity;

import java.lang.reflect.Type;

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
    SITE_INFO(SiteInfoConfigValue.class),

    /**
     * 管理员配置
     */
    ADMINISTRATOR(AdministratorConfigValue.class);

    /**
     * 配置值类型
     */
    private final Type valueType;

    ConfigName(Type valueType) {
        this.valueType = valueType;
    }

    @Override
    public ConfigName getId() {
        return this;
    }

    public Type getValueType() {
        return valueType;
    }
}
