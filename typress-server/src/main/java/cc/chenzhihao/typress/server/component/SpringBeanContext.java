package cc.chenzhihao.typress.server.component;

import cc.chenzhihao.typress.core.domain.component.bean.BeanContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 基于SpringIoC的BeanContext实现
 *
 * @author chenzhihao
 * @date 2023-10-08 14:30
 */
@Component
public class SpringBeanContext implements BeanContext, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
