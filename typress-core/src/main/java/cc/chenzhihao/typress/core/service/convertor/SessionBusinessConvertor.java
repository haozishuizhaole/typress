package cc.chenzhihao.typress.core.service.convertor;

import cc.chenzhihao.typress.core.domain.component.convertor.CommonDomainConvertor;
import cc.chenzhihao.typress.core.domain.component.convertor.SessionDomainConvertor;
import cc.chenzhihao.typress.core.domain.component.convertor.UserDomainConvertor;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import cc.chenzhihao.typress.core.domain.model.entity.User;
import cc.chenzhihao.typress.core.domain.model.vo.authenticate.PasswordCertification;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordRequestDTO;
import cc.chenzhihao.typress.core.service.dto.LoginByPasswordResponseDTO;
import cc.chenzhihao.typress.core.service.dto.SessionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * 会话业务层转换器
 *
 * @author chenzhihao
 * @date 2023-10-09 19:31
 */
public class SessionBusinessConvertor {

    private static final SessionMapper MAPPER = Mappers.getMapper(SessionMapper.class);

    public static PasswordCertification convertLoginByPasswordRequestDTOToPasswordCertification(LoginByPasswordRequestDTO source) {
        return MAPPER.convertLoginByPasswordRequestDTOToPasswordCertification(source);
    }

    public static SessionDTO convertSessionAndUserToSessionDTO(Session session, User user) {
        return MAPPER.convertSessionAndUserToSessionDTO(session, user);
    }

    public static LoginByPasswordResponseDTO convertSessionAndUserToLoginByPasswordResponseDTO(Session session, User user) {
        return new LoginByPasswordResponseDTO(convertSessionAndUserToSessionDTO(session, user));
    }

    @Mapper(
            imports = {CommonDomainConvertor.class, SessionDomainConvertor.class, UserDomainConvertor.class},
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
    )
    interface SessionMapper extends CommonDomainConvertor, SessionDomainConvertor, UserDomainConvertor {

        @Mappings({
                @Mapping(target = "password", source = "password", qualifiedByName = "convertOriginalPasswordStringToPasswordWithEncode")
        })
        PasswordCertification convertLoginByPasswordRequestDTOToPasswordCertification(LoginByPasswordRequestDTO source);

        @Mappings({
                @Mapping(target = "sessionId", source = "session.sessionId", qualifiedByName = "convertSessionIdToString"),
                @Mapping(target = "userId", source = "user.userId", qualifiedByName = "convertUserIdToLong")
        })
        SessionDTO convertSessionAndUserToSessionDTO(Session session, User user);
    }

}
