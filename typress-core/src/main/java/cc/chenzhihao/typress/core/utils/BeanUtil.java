package cc.chenzhihao.typress.core.utils;

import cc.chenzhihao.typress.core.domain.component.bean.BeanContext;
import lombok.NonNull;

import java.util.Objects;

/**
 * Bean工具
 *
 * @author chenzhihao
 * @date 2023-10-08 14:19
 */
public final class BeanUtil {

    private static BeanContext beanContext;

    public static void setContext(@NonNull BeanContext context) {
        if (Objects.isNull(beanContext)) {
            synchronized (BeanUtil.class) {
                if (Objects.isNull(beanContext)) {
                    beanContext = context;
                }
            }
        }
    }

    /**
     * 根据类型获取Bean
     *
     * @param cls Bean类型
     * @param <T> Bean类型
     * @return Bean
     */
    public static <T> T getBean(Class<T> cls) {
        return beanContext.getBean(cls);
    }

}
