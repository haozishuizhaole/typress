package cc.chenzhihao.typress.infras.persistence.impl.sqlite;

import cc.chenzhihao.typress.commons.exception.PersistenceException;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.infras.persistence.ConfigPersistence;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.convertor.ConfigPersistenceConvertor;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ConfigPOExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ext.ConfigPOExtMapper;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ConfigPO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基于SQLite的配置持久化层实现
 *
 * @author chenzhihao
 * @date 2023-12-29 17:33
 */
@Component
public class SQLiteConfigPersistence implements ConfigPersistence {

    @Resource
    private ConfigPOExtMapper mapper;

    @Override
    public void create(Config<?> entity) throws PersistenceException {
        ConfigPO po = ConfigPersistenceConvertor.convertConfigToConfigPO(entity);
        try {
            mapper.insert(po);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#insert error", e);
        }
    }

    @Override
    public int updateByConditionSelective(Config<?> entityData, ConfigCondition condition) throws PersistenceException {
        ConfigPO data = ConfigPersistenceConvertor.convertConfigToConfigPO(entityData);
        ConfigPOExample example = ConfigPersistenceConvertor.convertConfigConditionToConfigPOExample(condition);
        try {
            return mapper.updateByExampleSelective(data, example);
        } catch (Exception e) {
            throw new PersistenceException("execute ConfigPOExtMapper#updateByExampleSelective error", e);
        }
    }

    @Override
    public Config<?> getById(ConfigKey id) throws PersistenceException {
        ConfigCondition condition = new ConfigCondition();
        condition.createCriteria().configKeyEqualTo(id);
        List<Config<?>> configs = findByCondition(condition);
        if (CollectionUtils.isEmpty(configs)) {
            return null;
        }
        return configs.get(0);
    }

    @Override
    public List<Config<?>> findByCondition(ConfigCondition condition) throws PersistenceException {
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
