package cc.chenzhihao.typress.infras.persistence.impl.sqlite.configuration;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Mybatis配置
 *
 * @author chenzhihao
 * @date 2024-01-02 19:07
 */
@Configuration
@MapperScan("cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers")
public class SQLiteMybatisConfiguration {

    private static final String MYBATIS_MAPPER_LOCATIONS = "classpath:/mybatis/mapper/sqlite/*.xml,classpath:/mybatis/mapper/sqlite/*/*.xml";

    // @Bean
    // public MapperScannerConfigurer mapperScannerConfigurer(TypressConfig typressConfig) {
    //     String mapperBasePackage = typressConfig.getPersistenceConfig().getSqLite().getMybatis().getMapperInterfaceBasePackage();
    //     if (StringUtils.isBlank(mapperBasePackage)) {
    //         throw new RuntimeException("mybatis beans init failed, because mybatis mapper interface base package config is empty");
    //     }
    //     MapperScannerConfigurer configurer = new MapperScannerConfigurer();
    //     configurer.setBasePackage(mapperBasePackage);
    //     return configurer;
    // }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        List<Resource> mapperResources = new LinkedList<>();
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        for (String location : MYBATIS_MAPPER_LOCATIONS.split(",")) {
            Resource[] resources = patternResolver.getResources(location.trim());
            if (ArrayUtils.isEmpty(resources)) {
                continue;
            }
            mapperResources.addAll(Arrays.asList(resources));
        }

        if (CollectionUtils.isEmpty(mapperResources)) {
            throw new RuntimeException("mybatis mappers is empty");
        }

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(mapperResources.toArray(new Resource[0]));
        return bean.getObject();
    }

}
