package cc.chenzhihao.typress.infras.persistence.impl.sqlite.convertor;

import cc.chenzhihao.typress.commons.component.condition.Pageable;
import cc.chenzhihao.typress.core.component.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.config.convertor.ConfigCoreConvertor;
import cc.chenzhihao.typress.core.domain.config.entity.Config;
import cc.chenzhihao.typress.core.domain.config.vo.ConfigKey;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ConfigPOExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ConfigPO;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chenzhihao
 * @date 2024-01-09 16:50
 */
public class ConfigPersistenceConvertor {

    private static final ConfigMapper MAPPER = Mappers.getMapper(ConfigMapper.class);

    /**
     * Config<?> -> ConfigPO
     */
    public static ConfigPO convertConfigToConfigPO(Config<?> source) {
        return MAPPER.convertConfigToConfigPO(source);
    }

    /**
     * List<Config<?>> -> ConfigPO
     */
    public static List<ConfigPO> convertConfigToConfigPO(List<Config<?>> source) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        return source.stream().map(ConfigPersistenceConvertor::convertConfigToConfigPO).collect(Collectors.toList());
    }

    /**
     * ConfigPO -> Config<?>
     */
    public static Config<?> convertConfigPOToConfig(ConfigPO source) {
        return MAPPER.convertConfigPOToConfig(source);
    }

    /**
     * List<ConfigPO> -> List<Config<?>>
     */
    public static List<Config<?>> convertConfigPOToConfig(List<ConfigPO> source) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        return source.stream().map(ConfigPersistenceConvertor::convertConfigPOToConfig).collect(Collectors.toList());
    }

    /**
     * ConfigCondition -> ConfigPOExtExample
     */
    public static ConfigPOExtExample convertConfigConditionToConfigPOExtExample(ConfigCondition source) {
        if (source == null) {
            return null;
        }

        // Base
        ConfigPOExtExample target = new ConfigPOExtExample(convertConfigConditionToConfigPOExample(source));

        // 分页
        Pageable sourcePageable = source.getPageable();
        if (sourcePageable != null) {
            target.limit(sourcePageable.getOffset(), sourcePageable.getPageSize());
        }
        return target;
    }

    /**
     * ConfigCondition -> ConfigPOExample
     */
    public static ConfigPOExample convertConfigConditionToConfigPOExample(ConfigCondition source) {
        if (source == null) {
            return null;
        }
        ConfigPOExample target = new ConfigPOExample();
        for (ConfigCondition.Criteria sourceCriterion : source.getOredCriteria()) {
            ConfigPOExample.Criteria targetOrCriteria = target.or();
            populateConfigConditionCriteriaByConfigPOExampleCriteria(sourceCriterion, targetOrCriteria);
        }
        return target;
    }

    /**
     * ConfigCondition.Criteria -> ConfigPOExample.Criteria
     */
    public static void populateConfigConditionCriteriaByConfigPOExampleCriteria(ConfigCondition.Criteria source, ConfigPOExample.Criteria target) {
        if (source == null) {
            return;
        }

        // configKey == ?
        if (source.getConfigKeyEqualTo() != null) {
            target.andConfigKeyEqualTo(source.getConfigKeyEqualTo().name());
        }

    }

    @Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    interface ConfigMapper extends ConfigCoreConvertor {

        @Mappings({
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "configKey", qualifiedByName = "convertConfigKeyToString"),
                @Mapping(target = "configValue", qualifiedByName = "convertObjectToJsonString"),
                @Mapping(target = "createTime", qualifiedByName = "convertTimestampToLong"),
                @Mapping(target = "updateTime", qualifiedByName = "convertTimestampToLong"),
        })
        ConfigPO convertConfigToConfigPO(Config<?> source);

        default Config<?> convertConfigPOToConfig(ConfigPO source) {
            if (Objects.isNull(source)) {
                return null;
            }
            ConfigKey configKey = convertStringToConfigKey(source.getConfigKey());
            if (Objects.isNull(configKey)) {
                return null;
            }
            return new Config<>(
                    configKey,
                    convertJsonStringToObject(source.getConfigValue(), configKey.getConfigValueType()),
                    convertLongToTimestamp(source.getCreateTime()),
                    convertLongToTimestamp(source.getUpdateTime())
            );
        }

    }
}
