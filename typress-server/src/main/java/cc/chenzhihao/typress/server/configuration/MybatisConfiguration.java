package cc.chenzhihao.typress.server.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置
 *
 * @author chenzhihao
 * @date 2023-09-14 17:18
 */
@Configuration
@MapperScan("${mybatis.mapper-base-packages}")
public class MybatisConfiguration {

}
