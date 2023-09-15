package cc.chenzhihao.typress.core.domain.condition.base;

/**
 * 分页请求
 *
 * @author chenzhihao
 * @date 2023-09-14 20:26
 */
public class PageRequest implements Pageable {

    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NO = 1;

    /**
     * 默认每页个数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页码
     */
    private final int pageNo;

    /**
     * 每页元素个数
     */
    private final int pageSize;

    protected PageRequest(int pageNo, int pageSize) {
        this.pageNo = Math.max(pageNo, DEFAULT_PAGE_NO);
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public static PageRequest of(int pageNo, int pageSize) {
        return new PageRequest(pageNo, pageSize);
    }

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public long getOffset() {
        return (long) (pageNo - 1) * pageSize;
    }
}
