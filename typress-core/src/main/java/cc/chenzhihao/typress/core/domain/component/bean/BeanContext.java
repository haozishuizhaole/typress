package cc.chenzhihao.typress.core.domain.component.bean;

/**
 * Bean容器
 *
 * @author chenzhihao
 * @date 2023-10-07 16:38
 */
public interface BeanContext {

    /**
     * 根据类型获取Bean
     *
     * @param cls Bean类型
     * @param <T> Bean类型
     * @return Bean
     */
    <T> T getBean(Class<T> cls);
}
