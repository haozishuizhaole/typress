package cc.chenzhihao.typress.core.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通过密码登录 返回结果
 *
 * @author chenzhihao
 * @date 2023-10-09 18:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginByPasswordResponseDTO extends SessionDTO {
    private static final long serialVersionUID = -9131448997759788363L;

    public LoginByPasswordResponseDTO() {
    }

    public LoginByPasswordResponseDTO(String sessionId, Long userId) {
        super(sessionId, userId);
    }

    public LoginByPasswordResponseDTO(SessionDTO sessionDTO) {
        super(sessionDTO);
    }
}
