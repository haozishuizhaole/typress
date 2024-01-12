package cc.chenzhihao.typress.service.usecase;

import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.exception.ServiceException;
import cc.chenzhihao.typress.commons.model.dto.Status;
import cc.chenzhihao.typress.commons.util.ValidateUtil;
import cc.chenzhihao.typress.core.domain.config.vo.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.infras.repository.ConfigRepository;
import cc.chenzhihao.typress.core.service.convertor.ConfigServiceConvertor;
import cc.chenzhihao.typress.core.service.dto.req.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Config 用例实现
 *
 * @author chenzhihao
 * @date 2024-01-11 16:26
 */
@Service
public class ConfigUseCaseImpl implements ConfigUseCase {

    @Resource
    private ConfigRepository configRepository;

    @Override
    public GetSiteInfoConfigResponseDTO getSiteInfoConfig() throws ServiceException {
        // 获取配置值
        SiteInfoConfigValue configValue;
        try {
            if (Objects.isNull(configValue = configRepository.getSiteInfo())) {
                return null;
            }
        } catch (RepositoryException e) {
            throw new ServiceException("get site info config from repository failed", e);
        }

        // 结果转换
        return ConfigServiceConvertor.convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(configValue);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setSiteInfoConfig(SetSiteInfoConfigRequestDTO req) throws ServiceException {
        // 数据校验
        ValidateUtil.validate(req, Status.PARAM_ERROR);

        // 数据转换
        SiteInfoConfigValue configValue = ConfigServiceConvertor.convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(req);

        // 数据更新
        try {
            configRepository.setSiteInfo(configValue);
        } catch (RepositoryException e) {
            throw new ServiceException("set site info config to repository failed", e);
        }
    }
}
