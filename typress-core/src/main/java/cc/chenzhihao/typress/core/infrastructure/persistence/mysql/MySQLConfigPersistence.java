package cc.chenzhihao.typress.core.infrastructure.persistence.mysql;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Config;

import java.util.List;

/**
 * 基于MySQL的配置持久化层实现
 *
 * @author chenzhihao
 * @date 2023-09-18 20:17
 */
public class MySQLConfigPersistence implements ConfigPersistence {

    @Override
    public void create(Config<?> entity) throws PersistenceException {

    }

    @Override
    public int updateByConditionSelective(Config<?> entityData, ConfigCondition condition) throws PersistenceException {
        return 0;
    }

    @Override
    public List<Config<?>> findByCondition(ConfigCondition condition) throws PersistenceException {
        return null;
    }

    @Override
    public long countByCondition(ConfigCondition condition) throws PersistenceException {
        return 0;
    }
}
