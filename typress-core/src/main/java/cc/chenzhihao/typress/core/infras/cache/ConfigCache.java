package cc.chenzhihao.typress.core.infras.cache;

import cc.chenzhihao.typress.commons.component.cache.Cache;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;

/**
 * 配置 缓存
 *
 * @author chenzhihao
 * @date 2023-12-25 20:24
 */
public interface ConfigCache extends Cache<ConfigKey, Config<?>> {
}
