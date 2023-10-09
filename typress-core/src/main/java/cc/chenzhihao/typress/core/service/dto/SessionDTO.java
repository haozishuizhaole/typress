package cc.chenzhihao.typress.core.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 会话信息
 *
 * @author chenzhihao
 * @date 2023-10-09 18:37
 */
@Data
public class SessionDTO implements Serializable {

    private static final long serialVersionUID = 898486962125614908L;

    /**
     * 会话ID
     */
    private String sessionId;

    /**
     * 用户ID
     */
    private Long userId;

    public SessionDTO() {
    }

    public SessionDTO(String sessionId, Long userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public SessionDTO(SessionDTO sessionDTO) {
        if (Objects.isNull(sessionDTO)) {
            return;
        }
        this.sessionId = sessionDTO.sessionId;
        this.userId = sessionDTO.userId;
    }
}
