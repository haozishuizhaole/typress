package cc.chenzhihao.typress.core.domain.service.administer.impl;

import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.entity.Administer;
import cc.chenzhihao.typress.core.domain.model.vo.config.AdministratorConfigValue;
import cc.chenzhihao.typress.core.domain.model.vo.user.AdminUserId;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.domain.service.administer.AdministerService;

import java.util.Objects;

/**
 * 基于配置的管理员业务接口实现
 *
 * @author chenzhihao
 * @date 2023-10-09 15:51
 */
public class ConfigAdministerServiceImpl implements AdministerService {

    private final ConfigRepository configRepository;

    public ConfigAdministerServiceImpl(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @Override
    public Administer getAdminister() {
        AdministratorConfigValue administratorConfig;
        try {
            administratorConfig = configRepository.getAdministratorConfig();
        } catch (RepositoryException e) {
            throw new RuntimeException("get administrator config failed", e);
        }

        if (Objects.isNull(administratorConfig)) {
            return null;
        }
        return new Administer(AdminUserId.getInstance(), administratorConfig.getPassword());
    }
}
