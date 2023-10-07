package cc.chenzhihao.typress.core.service.convertor;

import cc.chenzhihao.typress.core.domain.component.convertor.CommonDomainConvertor;
import cc.chenzhihao.typress.core.domain.model.vo.config.AdministratorConfigValue;
import cc.chenzhihao.typress.core.domain.model.vo.config.SiteInfoConfigValue;
import cc.chenzhihao.typress.core.service.dto.GetSiteInfoConfigResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SetAdministratorConfigPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.SetSiteInfoConfigRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
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

    public static AdministratorConfigValue convertSetAdministratorConfigPasswordRequestDTOToAdministratorConfigValue(SetAdministratorConfigPasswordRequestDTO source) {
        return MAPPER.convertSetAdministratorConfigPasswordRequestDTOToAdministratorConfigValue(source);
    }

    @Mapper(
            imports = {CommonDomainConvertor.class},
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
    )
    interface ConfigMapper extends CommonDomainConvertor {

        GetSiteInfoConfigResponseDTO convertSiteInfoConfigValueToGetSiteInfoConfigResponseDTO(SiteInfoConfigValue source);

        SiteInfoConfigValue convertSetSiteInfoConfigRequestDTOToSiteInfoConfigValue(SetSiteInfoConfigRequestDTO source);

        @Mappings({
                @Mapping(target = "password", source = "newPassword", qualifiedByName = "convertOriginalPasswordStringToPasswordWithEncode")
        })
        AdministratorConfigValue convertSetAdministratorConfigPasswordRequestDTOToAdministratorConfigValue(SetAdministratorConfigPasswordRequestDTO source);
    }
}
