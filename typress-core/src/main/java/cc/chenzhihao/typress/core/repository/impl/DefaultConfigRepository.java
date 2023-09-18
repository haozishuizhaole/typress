package cc.chenzhihao.typress.core.repository.impl;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
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
    public void save(Config entity) throws RepositoryException {
        Config existConfig;
        try {
            existConfig = getByConfigKeyFromPersistence(entity.getConfigName());
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by configKey condition failed.", e);
        }

        // 新增
        if (Objects.isNull(existConfig)) {
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
        try {
            configPersistence.updateByConditionSelective(entity, condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("update config by configKey condition failed.", e);
        }
    }

    @Override
    public Config getById(ConfigName id) throws RepositoryException {
        Config config;
        try {
            config = getByConfigKeyFromPersistence(id);
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by configKey from persistence failed.", e);
        }
        return config;
    }

    private Config getByConfigKeyFromPersistence(ConfigName configName) throws PersistenceException {
        ConfigCondition condition = new ConfigCondition();
        condition.createCriteria().configNameEqualTo(configName);
        List<Config> configs = configPersistence.findByCondition(condition);
        if (CollectionUtils.isEmpty(configs)) {
            return null;
        }
        return configs.get(0);
    }
}
