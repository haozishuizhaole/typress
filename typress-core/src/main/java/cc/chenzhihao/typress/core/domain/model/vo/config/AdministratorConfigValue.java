package cc.chenzhihao.typress.core.domain.model.vo.config;

import cc.chenzhihao.typress.core.domain.model.vo.Password;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 管理员配置
 *
 * @author chenzhihao
 * @date 2023-09-22 15:52
 */
@Data
public class AdministratorConfigValue implements Serializable {

    private static final long serialVersionUID = 3023624481977999831L;

    /**
     * 管理员登录密码
     */
    private Password password;

    /**
     * 校验密码
     *
     * @param password 密码
     * @return true-正确，false-错误
     */
    public boolean checkPassword(Password password) {
        return Objects.equals(this.password, password);
    }
}
