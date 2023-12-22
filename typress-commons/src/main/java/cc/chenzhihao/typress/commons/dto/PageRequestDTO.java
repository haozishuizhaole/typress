package cc.chenzhihao.typress.commons.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 分页请求
 *
 * @author chenzhihao
 * @date 2023-12-22 17:58
 */
@Data
public class PageRequestDTO implements Serializable {

    private static final long serialVersionUID = 4873643849375220223L;

    public static final Integer DEFAULT_PAGE_NO = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 20;

    /**
     * 页码
     */
    private Integer pageNo = DEFAULT_PAGE_NO;

    /**
     * 每页个数
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public final void setPageNo(Integer pageNo) {
        if (Objects.isNull(pageNo) || pageNo <= 0) {
            pageNo = DEFAULT_PAGE_NO;
        }
        this.pageNo = pageNo;
    }

    public final void setPageSize(Integer pageSize) {
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }
}