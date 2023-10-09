package cc.chenzhihao.typress.core.domain.component.convertor;

import cc.chenzhihao.typress.core.domain.model.vo.user.UserId;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Objects;

/**
 * 用户领域转换器
 *
 * @author chenzhihao
 * @date 2023-10-09 19:59
 */
@Mapper
public interface UserDomainConvertor {

    /**
     * UserId -> Long
     */
    @Named("convertUserIdToLong")
    default Long convertUserIdToLong(UserId userId){
        if (Objects.isNull(userId)){
            return null;
        }
        return userId.getId();
    }

}
