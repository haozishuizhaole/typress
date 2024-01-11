package cc.chenzhihao.typress.core.service.convertor;

import cc.chenzhihao.typress.core.domain.config.convertor.ConfigCoreConvertor;
import cc.chenzhihao.typress.core.domain.config.vo.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.service.dto.resp.GetSiteConfigResponseDTO;
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
     * SiteInfoConfigValue -> GetSiteConfigResponseDTO
     */
    public static GetSiteConfigResponseDTO convertSiteInfoConfigValueToGetSiteConfigResponseDTO(SiteInfoConfigValue source) {
        return MAPPER.convertSiteInfoConfigValueToGetSiteConfigResponseDTO(source);
    }

    @Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    interface ConfigMapper extends ConfigCoreConvertor {

        GetSiteConfigResponseDTO convertSiteInfoConfigValueToGetSiteConfigResponseDTO(SiteInfoConfigValue source);
    }
}
