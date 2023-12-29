package cc.chenzhihao.typress.core.infras.repository;

import cc.chenzhihao.typress.commons.component.repository.Repository;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;

/**
 * 配置 资源库
 *
 * @author chenzhihao
 * @date 2023-12-23 23:18
 */
public interface ConfigRepository extends Repository<ConfigKey, Config<?>, ConfigCondition> {
}
