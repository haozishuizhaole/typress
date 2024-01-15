package cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ext;

import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ArticlePOMapper;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ArticlePO;

import java.util.List;

/**
 * @author chenzhihao
 * @date 2024-01-15 20:13
 */
public interface ArticlePOExtMapper extends ArticlePOMapper {


    /**
     * 根据扩展查询条件查询
     *
     * @param example 扩展查询条件
     * @return 查询结果
     */
    List<ArticlePO> selectByExtExample(ArticlePOExtExample example);

}
