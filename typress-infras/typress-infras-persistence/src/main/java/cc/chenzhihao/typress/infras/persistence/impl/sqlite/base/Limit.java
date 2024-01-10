package cc.chenzhihao.typress.infras.persistence.impl.sqlite.base;

import lombok.Data;

/**
 * 分页查询
 *
 * @author chenzhihao
 * @date 2023-09-15 15:46
 */
@Data
public class Limit {

    /**
     * 偏移量
     */
    private Long offset;

    /**
     * 条数
     */
    private Long size;

    private Limit(Long offset, Long size) {
        this.offset = offset;
        this.size = size;
    }

    public static Limit of(long offset, long size) {
        return new Limit(offset, size);
    }

}
