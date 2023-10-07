package cc.chenzhihao.typress.core.service.usecase.impl;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.exception.base.ServiceException;
import cc.chenzhihao.typress.core.domain.model.vo.Password;
import cc.chenzhihao.typress.core.domain.model.vo.config.AdministratorConfigValue;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.service.convertor.ConfigBusinessConvertor;
import cc.chenzhihao.typress.core.service.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SetAdministratorConfigPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCases;
import cc.chenzhihao.typress.core.utils.ValidateUtil;

import java.util.Objects;

/**
 * 配置用例接口实现
 *
 * @author chenzhihao
 * @date 2023-09-19 13:47
 */
public class ConfigUseCasesImpl implements ConfigUseCases {

    private final ConfigRepository configRepository;

    public ConfigUseCasesImpl(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @Override
    public GetSiteInfoConfigResponseDTO getSiteInfoConfig() throws ServiceException {
        SiteInfoConfigValue configValue;
        try {
            configValue = configRepository.getSiteInfoConfig();
        } catch (RepositoryException e) {
            throw new ServiceException("get site info config failed", e);
        }

        return ConfigBusinessConvertor.convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(configValue);
    }

    @Override
    public void setSiteInfoConfig(SetSiteInfoConfigRequestDTO request) throws ServiceException {
        // 参数校验
        ValidateUtil.validate(request);

        // 数据转换
        SiteInfoConfigValue configValue = ConfigBusinessConvertor.convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(request);

        // 调资源库
        try {
            configRepository.setSiteInfoConfig(configValue);
        } catch (RepositoryException e) {
            throw new ServiceException("set site info config failed", e);
        }
    }

    @Override
    public void setAdministratorConfigPassword(SetAdministratorConfigPasswordRequestDTO request) throws ServiceException {
        // 参数校验
        ValidateUtil.validate(request);

        // 获取管理员配置
        AdministratorConfigValue administratorConfig;
        try {
            administratorConfig = configRepository.getAdministratorConfig();
        } catch (RepositoryException e) {
            throw new ServiceException("get administrator config failed", e);
        }

        // 业务处理
        if (Objects.isNull(administratorConfig)) {
            // 配置不存在，直接保存
            administratorConfig = ConfigBusinessConvertor.convertSetAdministratorConfigPasswordRequestDTOToAdministratorConfigValue(request);
        } else if (!administratorConfig.checkPassword(new Password(request.getOldPassword(), true))) {
            // 原始密码校验失败，报错
            throw new BusinessException("原始密码错误");
        } else {
            administratorConfig.setPassword(new Password(request.getNewPassword(), true));
        }

        // 数据保存
        try {
            configRepository.setAdministratorConfig(administratorConfig);
        } catch (RepositoryException e) {
            throw new ServiceException("save administrator config for update password failed", e);
        }
    }
}
