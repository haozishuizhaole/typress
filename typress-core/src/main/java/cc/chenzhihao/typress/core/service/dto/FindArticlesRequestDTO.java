package cc.chenzhihao.typress.core.service.dto;

import cc.chenzhihao.typress.core.service.dto.base.PageRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查找文章 请求
 *
 * @author chenzhihao
 * @date 2023-09-21 19:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FindArticlesRequestDTO extends PageRequestDTO {

    private static final long serialVersionUID = 335100601597940376L;

    
}
