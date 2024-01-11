package cc.chenzhihao.typress.service.usecase;

import cc.chenzhihao.typress.commons.exception.RepositoryException;
import cc.chenzhihao.typress.commons.exception.ServiceException;
import cc.chenzhihao.typress.core.domain.config.vo.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.infras.repository.ConfigRepository;
import cc.chenzhihao.typress.core.service.convertor.ConfigServiceConvertor;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteConfigResponseDTO;
import cc.chenzhihao.typress.core.service.usecase.ConfigUseCase;
import org.springframework.stereotype.Service;

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
    public GetSiteConfigResponseDTO getSiteConfig() throws ServiceException {
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
        return ConfigServiceConvertor.convertSiteInfoConfigValueToGetSiteConfigResponseDTO(configValue);
    }
}
