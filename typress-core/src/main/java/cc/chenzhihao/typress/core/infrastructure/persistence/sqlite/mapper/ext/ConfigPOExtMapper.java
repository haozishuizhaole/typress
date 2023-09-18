package cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ext;

import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.mapper.ConfigPOMapper;
import cc.chenzhihao.typress.core.infrastructure.persistence.sqlite.po.ConfigPO;

import java.util.List;

/**
 * @author chenzhihao
 * @date 2023-09-15 15:43
 */
public interface ConfigPOExtMapper extends ConfigPOMapper {

    /**
     * 根据扩展查询条件查询
     *
     * @param example 扩展查询条件
     * @return 查询结果
     */
    List<ConfigPO> selectByExtExample(ConfigPOExtExample example);
}
