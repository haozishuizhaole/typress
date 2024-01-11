package cc.chenzhihao.typress.infras.repository.impl;

import cc.chenzhihao.typress.commons.exception.CacheException;
import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.infras.cache.ConfigCache;
import cc.chenzhihao.typress.core.infras.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.infras.repository.ConfigRepository;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    @Resource
    private ConfigCache configCache;

    private final Lock CACHE_LOCK = new ReentrantLock();

    @Override
    public void save(Config<?> entity) throws RepositoryException {
        // 新增
        if (!contains(entity.getConfigKey())) {
            try {
                configPersistence.create(entity);
                configCache.set(entity.getConfigKey(), entity);
            } catch (PersistenceException | CacheException e) {
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
            configCache.set(entity.getConfigKey(), entity);
        } catch (PersistenceException | CacheException e) {
            throw new RepositoryException("update config by condition selective failed", e);
        }
    }

    @Override
    public Config<?> getById(ConfigKey id) throws RepositoryException {
        // 从缓存获取
        Config<?> config;
        try {
            // TODO 此处应该使用布隆过滤器，后边优化一下
            if (Objects.nonNull(config = configCache.get(id))) {
                return config;
            }
        } catch (CacheException e) {
            throw new RepositoryException("get config by id from cache failed", e);
        }

        // 加锁进行读库更新缓存。只放行一个现成进行该操作，其余线程全部返回null
        if (!CACHE_LOCK.tryLock()) {
            return null;
        }

        // 查库更新缓存
        try {
            if (Objects.nonNull(config = configPersistence.getById(id))) {
                configCache.set(config.getConfigKey(), config);
            }
            return config;
        } catch (PersistenceException e) {
            throw new RepositoryException("get config by id failed", e);
        } catch (CacheException e) {
            throw new RepositoryException("set config to cache failed", e);
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
