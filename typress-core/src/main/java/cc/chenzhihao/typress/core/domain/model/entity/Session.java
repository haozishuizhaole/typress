package cc.chenzhihao.typress.core.domain.model.entity;

import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionData;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会话
 *
 * @author chenzhihao
 * @date 2023-10-08 14:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session implements Entity<SessionId> {

    private static final long serialVersionUID = 8157531880880271579L;

    /**
     * 会话ID
     */
    private SessionId sessionId;

    /**
     * 会话数据
     */
    private SessionData sessionData;

    /**
     * 会话创建时间
     */
    private Timestamp createTime;

    @Override
    public SessionId getId() {
        return sessionId;
    }
}
