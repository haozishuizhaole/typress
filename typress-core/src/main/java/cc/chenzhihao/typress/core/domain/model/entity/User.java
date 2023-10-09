package cc.chenzhihao.typress.core.domain.model.entity;

import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Password;
import cc.chenzhihao.typress.core.domain.model.vo.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author chenzhihao
 * @date 2023-10-09 13:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Entity<UserId> {

    private static final long serialVersionUID = -5915551357660541030L;

    /**
     * 用户ID
     */
    private UserId userId;

    /**
     * 密码
     */
    private Password password;

    @Override
    public UserId getId() {
        return null;
    }
}
