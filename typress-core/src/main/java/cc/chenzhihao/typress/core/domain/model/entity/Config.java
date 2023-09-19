package cc.chenzhihao.typress.core.domain.model.entity;

import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigValueWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置
 *
 * @author chenzhihao
 * @date 2023-09-14 20:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config implements Entity<ConfigName> {

    private static final long serialVersionUID = 7677558025805241599L;

    /**
     * 配置名称
     */
    private ConfigName configName;

    /**
     * 配置值
     */
    private ConfigValueWrapper<?> configValue;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    public Config(ConfigName configName, ConfigValueWrapper<?> configValue) {
        this(configName, configValue, new Timestamp(), new Timestamp());
    }

    @Override
    public ConfigName getId() {
        return configName;
    }

    public <U> U getConfigValue(Class<U> clz) {
        return clz.cast(configValue.getValue());
    }

}
