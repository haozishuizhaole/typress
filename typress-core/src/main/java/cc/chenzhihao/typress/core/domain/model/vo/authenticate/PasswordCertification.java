package cc.chenzhihao.typress.core.domain.model.vo.authenticate;

import cc.chenzhihao.typress.core.domain.model.vo.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码凭证
 *
 * @author chenzhihao
 * @date 2023-10-08 18:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordCertification implements Certification {

    private static final long serialVersionUID = 8068142189886662451L;

    /**
     * 密码
     */
    private Password password;
}
