package cc.chenzhihao.typress.core.infras.repository;

import cc.chenzhihao.typress.commons.component.repository.Repository;
import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.config.entity.Config;
import cc.chenzhihao.typress.core.domain.config.vo.ConfigKey;
import cc.chenzhihao.typress.core.domain.config.vo.SiteInfoConfigValue;

/**
 * 配置 资源库
 *
 * @author chenzhihao
 * @date 2023-12-23 23:18
 */
public interface ConfigRepository extends Repository<ConfigKey, Config<?>, ConfigCondition> {

    /**
     * 获取站点信息
     */
    SiteInfoConfigValue getSiteInfo() throws RepositoryException;

    /**
     * 设置站点信息
     */
    void setSiteInfo(SiteInfoConfigValue configValue) throws RepositoryException;
}
