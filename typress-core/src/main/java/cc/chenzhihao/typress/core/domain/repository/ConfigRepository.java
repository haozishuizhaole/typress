package cc.chenzhihao.typress.core.domain.repository;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.domain.repository.base.Repository;

/**
 * 配置资源库
 *
 * @author chenzhihao
 * @date 2023-09-15 14:22
 */
public interface ConfigRepository extends Repository<ConfigName, Config, ConfigCondition> {

    /**
     * 获取站点信息配置
     *
     * @return 站点信息配置数据
     * @throws RepositoryException 资源库异常
     */
    SiteInfoConfigValue getSiteInfoConfig() throws RepositoryException;

    /**
     * 修改站点信息配置
     *
     * @param configValue 站点信息配置数据
     * @throws RepositoryException 资源库异常
     */
    void setSiteInfoConfig(SiteInfoConfigValue configValue) throws RepositoryException;
}
