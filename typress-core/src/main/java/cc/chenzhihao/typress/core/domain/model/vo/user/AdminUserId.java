package cc.chenzhihao.typress.core.domain.model.vo.user;

/**
 * 管理员用户ID
 *
 * @author chenzhihao
 * @date 2023-10-09 14:00
 */
public final class AdminUserId extends UserId {

    private static final long serialVersionUID = 2962672575895235879L;

    private static final long DEFAULT_ADMIN_USER_ID = 1L;

    private static final AdminUserId INSTANCE = new AdminUserId();

    private AdminUserId() {
        super(DEFAULT_ADMIN_USER_ID);
    }

    public static AdminUserId getInstance() {
        return INSTANCE;
    }
}
