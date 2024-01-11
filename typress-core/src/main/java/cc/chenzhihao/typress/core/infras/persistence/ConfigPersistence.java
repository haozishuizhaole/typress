package cc.chenzhihao.typress.core.infras.persistence;

import cc.chenzhihao.typress.commons.component.persistence.Persistence;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.config.entity.Config;
import cc.chenzhihao.typress.core.domain.config.vo.ConfigKey;

/**
 * 配置 持久化
 *
 * @author chenzhihao
 * @date 2023-12-25 20:17
 */
public interface ConfigPersistence extends Persistence<ConfigKey, Config<?>, ConfigCondition> {
}
