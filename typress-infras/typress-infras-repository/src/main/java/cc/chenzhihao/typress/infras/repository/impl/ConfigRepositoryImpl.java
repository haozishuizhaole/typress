package cc.chenzhihao.typress.infras.repository.impl;

import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.infras.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.infras.repository.ConfigRepository;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Config资源库实现
 *
 * @author chenzhihao
 * @date 2024-01-10 20:39
 */
@Component
public class ConfigRepositoryImpl implements ConfigRepository {

    @Resource
    private ConfigPersistence configPersistence;

    @Override
    public void save(Config<?> entity) throws RepositoryException {
        // 新增
        if (!contains(entity.getId())) {
            try {
                configPersistence.create(entity);
            } catch (PersistenceException e) {
                throw new RepositoryException("create config failed", e);
            }
            return;
        }

        // 更新
        ConfigCondition condition = new ConfigCondition();
        condition.createCriteria().configKeyEqualTo(entity.getConfigKey());
        entity = new Config<>(null, entity.getConfigValue(), null, new Timestamp());
        try {
            configPersistence.updateByConditionSelective(entity, condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("update config by condition selective failed", e);
        }
    }

    @Override
    public Config<?> getById(ConfigKey id) throws RepositoryException {
        try {
            return configPersistence.getById(id);
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by id failed", e);
        }
    }

    @Override
    public boolean contains(ConfigKey id) throws RepositoryException {
        return Objects.nonNull(getById(id));
    }

    @Override
    public long countByCondition(ConfigCondition condition) throws RepositoryException {
        try {
            return configPersistence.countByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("count by condition failed", e);
        }
    }

    @Override
    public List<Config<?>> getByCondition(ConfigCondition condition) throws RepositoryException {
        try {
            return configPersistence.findByCondition(condition);
        } catch (PersistenceException e) {
            throw new RepositoryException("get by condition failed", e);
        }
    }
}
