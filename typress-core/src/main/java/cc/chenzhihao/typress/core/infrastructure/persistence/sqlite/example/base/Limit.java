package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.base;

/**
 * 分页查询
 *
 * @author chenzhihao
 * @date 2023-09-15 15:46
 */
public class Limit {

    /**
     * 偏移量
     */
    private Long offset;

    /**
     * 条数
     */
    private Long size;

    public Limit(Long offset, Long size) {
        this.offset = offset;
        this.size = size;
    }

    public static Limit of(long offset, long size) {
        return new Limit(offset, size);
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
