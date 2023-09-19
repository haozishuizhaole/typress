package cc.chenzhihao.typress.core.business.convertor;

import cc.chenzhihao.typress.core.business.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.business.dto.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 配置业务层转换器
 *
 * @author chenzhihao
 * @date 2023-09-19 16:05
 */
public class ConfigBusinessConvertor {

    private static final ConfigMapper MAPPER = Mappers.getMapper(ConfigMapper.class);

    public static GetSiteInfoConfigResponseDTO convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(SiteInfoConfigValue source) {
        return MAPPER.convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(source);
    }

    public static SiteInfoConfigValue convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(SetSiteInfoConfigRequestDTO source) {
        return MAPPER.convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(source);
    }

    @Mapper
    interface ConfigMapper {

        GetSiteInfoConfigResponseDTO convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(SiteInfoConfigValue source);

        SiteInfoConfigValue convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(SetSiteInfoConfigRequestDTO source);
    }
}
