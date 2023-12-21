package cc.chenzhihao.typress.core.domain.component.initial;

/**
 * 应用程序初始化器
 *
 * @author chenzhihao
 * @date 2023-12-20 20:36
 */
public interface ApplicationInitializer {

    /**
     * 是否已经完成初始化
     *
     * @return true - 是，false - 否
     */
    boolean hasInitialize();

    /**
     * 设置初始化标记
     *
     * @param flag 初始化标记。true 已经初始化，false 未初始化
     */
    void setInitialize(boolean flag);
}
