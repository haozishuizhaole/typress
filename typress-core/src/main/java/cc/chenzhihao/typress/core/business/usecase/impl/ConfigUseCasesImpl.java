package cc.chenzhihao.typress.core.business.usecase.impl;

import cc.chenzhihao.typress.core.business.convertor.ConfigBusinessConvertor;
import cc.chenzhihao.typress.core.business.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.business.exception.BusinessException;
import cc.chenzhihao.typress.core.business.usecase.ConfigUseCases;
import cc.chenzhihao.typress.core.domain.exception.base.RepositoryException;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.domain.repository.ConfigRepository;
import cc.chenzhihao.typress.core.utils.ValidateUtil;

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
    public GetSiteInfoConfigResponseDTO getSiteInfoConfig() {
        SiteInfoConfigValue configValue;
        try {
            configValue = configRepository.getSiteInfoConfig();
        } catch (RepositoryException e) {
            throw new BusinessException("get site info config failed", e);
        }

        return ConfigBusinessConvertor.convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(configValue);
    }

    @Override
    public void setSiteInfoConfig(SetSiteInfoConfigRequestDTO request) {
        // 参数校验
        ValidateUtil.validate(request);

        // 数据转换
        SiteInfoConfigValue configValue = ConfigBusinessConvertor.convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(request);

        // 调资源库
        try {
            configRepository.setSiteInfoConfig(configValue);
        } catch (RepositoryException e) {
            throw new BusinessException("set site info config failed", e);
        }
    }
}
