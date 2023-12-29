package cc.chenzhihao.typress.infras.cache;

import cc.chenzhihao.typress.commons.component.cache.EntityMemoryCache;
import cc.chenzhihao.typress.core.infras.cache.ConfigCache;
import cc.chenzhihao.typress.core.model.config.entity.Config;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * 基于内存的Config缓存
 *
 * @author chenzhihao
 * @date 2023-12-29 15:08
 */
@Component
public class MemoryConfigCache extends EntityMemoryCache<ConfigKey, Config<?>> implements ConfigCache {

    public MemoryConfigCache() {
        // TODO @chenzhihao 2023/12/29 Config缓存过期时间可配置
        super(Duration.ofHours(1));
    }

}
