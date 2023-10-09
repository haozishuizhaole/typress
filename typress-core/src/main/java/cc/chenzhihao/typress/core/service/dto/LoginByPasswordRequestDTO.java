package cc.chenzhihao.typress.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 通过密码登录 请求
 *
 * @author chenzhihao
 * @date 2023-10-09 18:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginByPasswordRequestDTO implements Serializable {

    private static final long serialVersionUID = 6104570533292962855L;

    /**
     * 密码
     */
    @NotBlank(message = "${login.password.notBlank}")
    private String password;
}
