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

}
