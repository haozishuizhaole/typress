package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext;

import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ArticlePOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ArticlePOMapper;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ArticlePO;

import java.util.List;

public interface ArticlePOExtMapper extends ArticlePOMapper {

    /**
     * 根据扩展查询条件查询
     *
     * @param example 扩展查询条件
     * @return 查询结果
     */
    List<ArticlePO> selectByExtExample(ArticlePOExtExample example);
}