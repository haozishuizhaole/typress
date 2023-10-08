package cc.chenzhihao.typress.server.component.initial;

import cc.chenzhihao.typress.core.domain.component.bean.BeanContext;
import cc.chenzhihao.typress.core.utils.BeanUtil;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * BeanUtil初始化
 *
 * @author chenzhihao
 * @date 2023-10-08 14:34
 */
@Configuration
public class BeanUtilInitializer {

    @Resource
    private BeanContext beanContext;

    @PostConstruct
    public void init() {
        BeanUtil.setContext(beanContext);
    }

}
