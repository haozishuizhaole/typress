package cc.chenzhihao.typress.infras.cache;

import cc.chenzhihao.typress.commons.exception.CacheException;
import cc.chenzhihao.typress.core.domain.config.entity.Config;
import cc.chenzhihao.typress.core.domain.config.vo.ConfigKey;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenzhihao
 * @date 2023-12-29 15:11
 */
public class MemoryConfigCacheTest {

    @Test
    public void name() throws CacheException {
        MemoryConfigCache cache = new MemoryConfigCache();
        Config<?> config = new Config<>(ConfigKey.SITE_INFO, "asdasd");
        cache.set(config.getConfigKey(), config);
        Assert.assertSame(cache.get(config.getConfigKey()), config);
    }
}