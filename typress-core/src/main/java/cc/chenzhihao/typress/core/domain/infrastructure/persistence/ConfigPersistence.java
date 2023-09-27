package cc.chenzhihao.typress.core.domain.infrastructure.persistence;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.infrastructure.persistence.base.Persistence;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;

/**
 * 配置持久层接口
 *
 * @author chenzhihao
 * @date 2023-09-15 15:18
 */
public interface ConfigPersistence extends Persistence<ConfigName, Config<?>, ConfigCondition> {
}
