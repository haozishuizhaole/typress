package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.exception.base.PersistenceException;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.convertor.ConfigPersistenceConvertor;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ConfigPOExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext.ConfigPOExtMapper;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ConfigPO;

import java.util.List;

/**
 * 基于SQLite的配置持久化层实现
 *
 * @author chenzhihao
 * @date 2023-09-15 15:42
 */
public class SqLiteConfigPersistence implements ConfigPersistence {

    private final ConfigPOExtMapper mapper;

    public SqLiteConfigPersistence(ConfigPOExtMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void create(Config entity) throws PersistenceException {
        ConfigPO po = ConfigPersistenceConvertor.convertConfigToConfigPO(entity);
        try {
            mapper.insert(po);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#insert error", e);
        }
    }

    @Override
    public int updateByConditionSelective(Config entityData, ConfigCondition condition) throws PersistenceException {
        ConfigPO data = ConfigPersistenceConvertor.convertConfigToConfigPOSelective(entityData);
        ConfigPOExample example = ConfigPersistenceConvertor.convertConfigConditionToConfigPOExample(condition);
        try {
            return mapper.updateByExampleSelective(data, example);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#updateByExampleSelective error", e);
        }
    }

    @Override
    public List<Config> findByCondition(ConfigCondition condition) throws PersistenceException {
        ConfigPOExtExample queryCondition = ConfigPersistenceConvertor.convertConfigConditionToConfigPOExtExample(condition);
        List<ConfigPO> queryResult;
        try {
            queryResult = mapper.selectByExtExample(queryCondition);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#selectByExtExample error", e);
        }
        return ConfigPersistenceConvertor.convertConfigPOToConfig(queryResult);
    }

    @Override
    public long countByCondition(ConfigCondition condition) throws PersistenceException {
        ConfigPOExtExample queryCondition = ConfigPersistenceConvertor.convertConfigConditionToConfigPOExtExample(condition);
        try {
            return mapper.countByExample(queryCondition);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#countByExample error", e);
        }
    }

}
