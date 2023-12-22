package cc.chenzhihao.typress.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用程序启动入口
 *
 * @author chenzhihao
 * @date 2023-12-22 15:52
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("cc.chenzhihao.typress")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
