package cc.chenzhihao.typress.server.component.initial;

import cc.chenzhihao.typress.core.domain.component.initial.ApplicationInitializer;
import cc.chenzhihao.typress.server.component.config.TypressConfig;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 默认应用程序初始化执行器
 *
 * @author chenzhihao
 * @date 2023-12-20 20:32
 */
@Component
public class DefaultApplicationInitializer implements ApplicationInitializer {

    private transient Boolean isInitialize;

    private final TypressConfig typressConfig;

    public DefaultApplicationInitializer(TypressConfig typressConfig) {
        this.typressConfig = typressConfig;
    }

    @Override
    public boolean hasInitialize() {
        if (Objects.isNull(isInitialize)) {
            synchronized (DefaultApplicationInitializer.class) {
                if (Objects.isNull(isInitialize)) {
                    isInitialize = checkInitialize();
                }
            }
        }
        return isInitialize;
    }

    private boolean checkInitialize() {
        return true;
    }

    @Override
    public void setInitialize(boolean flag) {
        isInitialize = flag;
    }
}
