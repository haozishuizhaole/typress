package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.convertor;

import cc.chenzhihao.typress.core.domain.condition.ConfigCondition;
import cc.chenzhihao.typress.core.domain.condition.base.Pageable;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigValueWrapper;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ConfigPOExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ConfigPO;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chenzhihao
 * @date 2023-09-15 15:49
 */
public class ConfigPersistenceConvertor {

    private static final ConfigMapper MAPPER = Mappers.getMapper(ConfigMapper.class);


    public static ConfigPO convertConfigToConfigPO(Config source) {
        return MAPPER.convertConfigToConfigPO(source);
    }

    public static ConfigPO convertConfigToConfigPOSelective(Config source) {
        if (Objects.isNull(source)) {
            return null;
        }

        ConfigPO target = new ConfigPO();
        Optional.ofNullable(source.getConfigName()).map(ConfigName::name).ifPresent(target::setConfigName);
        Optional.ofNullable(source.getConfigValue()).map(JSON::toJSONString).ifPresent(target::setConfigValue);
        Optional.ofNullable(source.getCreateTime()).map(Timestamp::getValue).ifPresent(target::setCreateTime);
        Optional.ofNullable(source.getUpdateTime()).map(Timestamp::getValue).ifPresent(target::setUpdateTime);

        return target;
    }

    public static List<Config> convertConfigPOToConfig(List<ConfigPO> source) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        return source.stream().map(ConfigPersistenceConvertor::convertConfigPOToConfig).collect(Collectors.toList());
    }

    public static Config convertConfigPOToConfig(ConfigPO source) {
        if (Objects.isNull(source)) {
            return null;
        }

        ConfigName configName = ConfigName.valueOf(source.getConfigName());
        ConfigValueWrapper<Object> configValue = JSON.parseObject(source.getConfigValue(), new TypeReference<ConfigValueWrapper<Object>>() {
        });
        Object value = configValue.getValue();
        if (value instanceof JSONObject) {
            configValue.setValue(((JSONObject) value).toJavaObject(configName.getValueType()));
        } else if (value instanceof JSONArray) {
            configValue.setValue(((JSONArray) value).toJavaList(configName.getClass()));
        }

        return new Config(configName, configValue, new Timestamp(source.getCreateTime()), new Timestamp(source.getUpdateTime()));
    }

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

    public static void populateConfigConditionCriteriaByConfigPOExampleCriteria(ConfigCondition.Criteria source, ConfigPOExample.Criteria target) {
        if (source == null) {
            return;
        }

        // configName == ?
        if (source.getConfigNameEqualTo() != null) {
            target.andConfigNameEqualTo(source.getConfigNameEqualTo().name());
        }

    }

    @Mapper
    interface ConfigMapper {
        @Mappings({
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "configName", expression = "java(source.getConfigName().name())"),
                @Mapping(target = "configValue", expression = "java(com.alibaba.fastjson2.JSON.toJSONString(source.getConfigValue()))"),
                @Mapping(target = "createTime", expression = "java(new cc.chenzhihao.typress.core.domain.model.vo.Timestamp().getValue())"),
                @Mapping(target = "updateTime", expression = "java(new cc.chenzhihao.typress.core.domain.model.vo.Timestamp().getValue())"),
        })
        ConfigPO convertConfigToConfigPO(Config source);


    }
}
