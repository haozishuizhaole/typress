package cc.chenzhihao.typress.core.model.config.entity;

import cc.chenzhihao.typress.commons.model.entity.Entity;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置
 *
 * @author chenzhihao
 * @date 2023-12-23 23:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config<T> implements Entity<ConfigKey> {

    private static final long serialVersionUID = 4173861245936598565L;

    /**
     * 配置key
     */
    private ConfigKey configKey;

    /**
     * 配置Value
     */
    private T configValue;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    public Config(ConfigKey configKey, T configValue) {
        this(configKey, configValue, new Timestamp(), new Timestamp());
    }

    @Override
    public ConfigKey getId() {
        return configKey;
    }
}
