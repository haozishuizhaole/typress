package cc.chenzhihao.typress.core.domain.repository;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.repository.base.Repository;

/**
 * 配置资源库
 *
 * @author chenzhihao
 * @date 2023-09-15 14:22
 */
public interface ConfigRepository extends Repository<ConfigName, Config, ConfigCondition> {
}
