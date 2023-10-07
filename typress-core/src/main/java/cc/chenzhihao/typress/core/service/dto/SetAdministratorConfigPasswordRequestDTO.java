package cc.chenzhihao.typress.core.service.dto;

import cc.chenzhihao.typress.core.domain.component.verify.Verifiable;
import cc.chenzhihao.typress.core.domain.exception.ValidateFailedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chenzhihao
 * @date 2023-09-27 14:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetAdministratorConfigPasswordRequestDTO implements Serializable, Verifiable {

    private static final long serialVersionUID = 3335578857466383372L;

    /**
     * 旧密码
     */
    @NotBlank(message = "{config.administrator.password.old.notblank}")
    private String oldPassword;

    /**
     * 新密码
     */
    @NotBlank(message = "{config.administrator.password.new.notblank}")
    // TODO @chenzhihao 2023/9/27 min & max 可配置化
    @Length(message = "{config.administrator.password.new.length}", min = 6, max = 18)
    private String newPassword;

    @Override
    public void validate() throws ValidateFailedException {
        if (StringUtils.equals(oldPassword, newPassword)) {
            // TODO @chenzhihao 2023/9/27 i18n
            throw new ValidateFailedException("新旧密码相同，请提供有别于旧密码的新苗");
        }
    }
}
