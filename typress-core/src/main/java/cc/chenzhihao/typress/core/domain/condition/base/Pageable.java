package cc.chenzhihao.typress.core.domain.condition.base;

/**
 * 可分页的，用于分页查询
 *
 * @author chenzhihao
 * @date 2023-09-14 20:25
 */
public interface Pageable {

    /**
     * 获取页码
     *
     * @return 页码
     */
    int getPageNo();

    /**
     * 获取每页个数
     *
     * @return 每页个数
     */
    int getPageSize();

    /**
     * 获取偏移量
     *
     * @return 偏移量
     */
    long getOffset();
}
