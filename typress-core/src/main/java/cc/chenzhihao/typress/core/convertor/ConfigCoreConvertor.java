package cc.chenzhihao.typress.core.convertor;

import cc.chenzhihao.typress.commons.convertor.BaseConvertor;
import cc.chenzhihao.typress.core.model.config.vo.ConfigKey;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * Config核心转换器
 *
 * @author chenzhihao
 * @date 2024-01-09 18:57
 */
@Mapper
public interface ConfigCoreConvertor extends BaseConvertor {

    /**
     * ConfigKey -> String
     */
    @Named("convertConfigKeyToString")
    default String convertConfigNameToString(ConfigKey source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return source.name();
    }

    /**
     * String -> ConfigKey
     */
    @Named("convertStringToConfigKey")
    default ConfigKey convertStringToConfigKey(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        return ConfigKey.valueOf(source);
    }
}
