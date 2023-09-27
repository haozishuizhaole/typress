package cc.chenzhihao.typress.core.repository.impl;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.config.AdministratorConfigValue;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * 默认配置资源库实现
 *
 * @author chenzhihao
 * @date 2023-09-15 14:23
 */
public class DefaultConfigRepository implements ConfigRepository {

    private final ConfigPersistence configPersistence;

    public DefaultConfigRepository(ConfigPersistence configPersistence) {
        this.configPersistence = configPersistence;
    }

    @Override
    public void save(Config<?> entity) throws RepositoryException {
        Config<?> existConfig;
        try {
            existConfig = getByConfigKeyFromPersistence(entity.getConfigName());
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by configKey condition failed.", e);
        }

        // 新增
        if (Objects.isNull(existConfig)) {
            if (Objects.isNull(entity.getCreateTime())) {
                entity.setCreateTime(new Timestamp());
            }
            if (Objects.isNull(entity.getUpdateTime())) {
                entity.setUpdateTime(new Timestamp());
            }
            try {
                configPersistence.create(entity);
            } catch (PersistenceException e) {
                throw new RepositoryException("create config failed.", e);
            }
            return;
        }

        // 更新
        ConfigCondition condition = new ConfigCondition();
        condition.createCriteria().configNameEqualTo(entity.getConfigName());
        entity.setConfigName(null);
        entity.setCreateTime(null);
        try {
            configPersistence.updateByConditionSelective(entity, condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("update config by configKey condition failed.", e);
        }
    }

    @Override
    public Config<?> getById(ConfigName id) throws RepositoryException {
        Config<?> config;
        try {
            config = getByConfigKeyFromPersistence(id);
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by configKey from persistence failed.", e);
        }
        return config;
    }

    private Config<?> getByConfigKeyFromPersistence(ConfigName configName) throws PersistenceException {
        ConfigCondition condition = new ConfigCondition();
        condition.createCriteria().configNameEqualTo(configName);
        List<Config<?>> configs = configPersistence.findByCondition(condition);
        if (CollectionUtils.isEmpty(configs)) {
            return null;
        }
        return configs.get(0);
    }

    /**
     * 获取配置值
     *
     * @param configName 配置名
     * @param <T>        配置值类型
     * @return 配置值
     * @throws RepositoryException 资源库异常
     */
    private <T> T getConfigValue(ConfigName configName) throws RepositoryException {
        Config<?> config = getById(configName);
        if (Objects.isNull(config)) {
            return null;
        }
        try {
            return (T) config.getConfigValue();
        } catch (Exception e) {
            throw new RepositoryException(String.format("case configValue type to %s failed, configValue type is %s", configName.getValueType().toString(), config.getConfigValue().getClass().toString()));
        }
    }

    /**
     * 保存配置值
     *
     * @param configName  配置名
     * @param configValue 配置值
     * @param <T>         配置值类型
     * @throws RepositoryException 资源库异常
     */
    private <T> void saveConfigValue(ConfigName configName, T configValue) throws RepositoryException {
        save(new Config<>(configName, configValue));
    }

    @Override
    public SiteInfoConfigValue getSiteInfoConfig() throws RepositoryException {
        return getConfigValue(ConfigName.SITE_INFO);
    }

    @Override
    public void setSiteInfoConfig(SiteInfoConfigValue configValue) throws RepositoryException {
        saveConfigValue(ConfigName.SITE_INFO, configValue);
    }

    @Override
    public AdministratorConfigValue getAdministratorConfig() throws RepositoryException {
        return getConfigValue(ConfigName.ADMINISTRATOR);
    }

    @Override
    public void setAdministratorConfig(AdministratorConfigValue configValue) throws RepositoryException {
        saveConfigValue(ConfigName.ADMINISTRATOR, configValue);
    }
}
