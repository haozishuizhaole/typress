package cc.chenzhihao.typress.core.service.convertor;

import cc.chenzhihao.typress.core.domain.config.convertor.ConfigCoreConvertor;
import cc.chenzhihao.typress.core.domain.config.vo.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.service.dto.req.SetSiteInfoConfigRequestDTO;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteInfoConfigResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Config业务层转换器
 *
 * @author chenzhihao
 * @date 2024-01-11 16:40
 */
public class ConfigServiceConvertor {

    private static final ConfigMapper MAPPER = Mappers.getMapper(ConfigMapper.class);


    /**
     * SiteInfoConfigValue -> GetSiteInfoConfigResponseDTO
     */
    public static GetSiteInfoConfigResponseDTO convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(SiteInfoConfigValue source) {
        return MAPPER.convertSiteInfoConfigValueToGetSiteConfigResponseDTO(source);
    }

    /**
     * SetSiteInfoConfigRequestDTO -> SiteInfoConfigValue
     */
    public static SiteInfoConfigValue convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(SetSiteInfoConfigRequestDTO source) {
        return MAPPER.convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(source);
    }

    @Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    interface ConfigMapper extends ConfigCoreConvertor {

        GetSiteInfoConfigResponseDTO convertSiteInfoConfigValueToGetSiteConfigResponseDTO(SiteInfoConfigValue source);

        SiteInfoConfigValue convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(SetSiteInfoConfigRequestDTO source);
    }
}
