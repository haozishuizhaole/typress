package cc.chenzhihao.typress.core.domain.model.vo.session;

import lombok.Builder;
import lombok.Data;

/**
 * 登录选项
 *
 * @author chenzhihao
 * @date 2023-10-09 14:12
 */
@Data
@Builder
public class LoginOptions {

    private static final LoginOptions DEFAULT = LoginOptions.builder().build();

    public static LoginOptions getDefault() {
        return DEFAULT;
    }

    /**
     * 登录成功后，是否将该用户的其他会话强制下线。true-是，false-否
     * 默认false，即登录后创建新的会话，该用户在其他设备登录的会话不会强制下线
     */
    private Boolean isCloseOtherSession;

}
