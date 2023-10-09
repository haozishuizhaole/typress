package cc.chenzhihao.typress.core.domain.model.entity;

import cc.chenzhihao.typress.core.domain.model.vo.Password;
import cc.chenzhihao.typress.core.domain.model.vo.user.UserId;

/**
 * 管理员
 *
 * @author chenzhihao
 * @date 2023-10-09 13:58
 */
public class Administer extends User {

    private static final long serialVersionUID = 6432173690012304830L;

    public Administer(UserId userId, Password password) {
        super(userId, password);
    }
}
