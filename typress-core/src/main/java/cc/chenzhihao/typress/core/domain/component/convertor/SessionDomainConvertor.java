package cc.chenzhihao.typress.core.domain.component.convertor;

import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * 会话领域转换器
 *
 * @author chenzhihao
 * @date 2023-10-09 19:57
 */
@Mapper
public interface SessionDomainConvertor {

    /**
     * SessionId -> String
     */
    @Named("convertSessionIdToString")
    default String convertSessionIdToString(SessionId sessionId) {
        if (Objects.isNull(sessionId)) {
            return null;
        }
        return sessionId.getId();
    }
}
