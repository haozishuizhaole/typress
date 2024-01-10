package cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ext;

import cc.chenzhihao.typress.infras.persistence.impl.sqlite.example.ext.ConfigPOExtExample;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.mappers.ConfigPOMapper;
import cc.chenzhihao.typress.infras.persistence.impl.sqlite.pos.ConfigPO;

import java.util.List;

/**
 * Config Mapper 接口扩展
 *
 * @author chenzhihao
 * @date 2023-12-29 17:33
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
