package cc.chenzhihao.typress.bootstrap.configuration;

import cc.chenzhihao.typress.commons.util.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Jackson 配置
 *
 * @author chenzhihao
 * @date 2023-12-23 14:53
 */
@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JSONUtil.getMapper();
    }

}
