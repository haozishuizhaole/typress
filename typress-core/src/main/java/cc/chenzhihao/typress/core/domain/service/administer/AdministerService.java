package cc.chenzhihao.typress.core.domain.service.administer;

import cc.chenzhihao.typress.core.domain.model.entity.Administer;

/**
 * 管理员业务接口
 *
 * @author chenzhihao
 * @date 2023-10-09 15:50
 */
public interface AdministerService {

    /**
     * 获取管理员信息
     *
     * @return 管理员
     */
    Administer getAdminister();

}
