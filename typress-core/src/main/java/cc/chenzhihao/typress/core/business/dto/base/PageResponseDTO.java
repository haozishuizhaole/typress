package cc.chenzhihao.typress.core.business.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页响应
 *
 * @author chenzhihao
 * @date 2023-09-21 19:26
 */
@Data
public class PageResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 4492475984037557021L;

    /**
     * 总数
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> list;

    public PageResponseDTO() {
    }

    public PageResponseDTO(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }
}