package cc.chenzhihao.typress.core.domain.model.vo.user;

import cc.chenzhihao.typress.core.domain.model.vo.ID;
import lombok.NonNull;

import java.time.Instant;

/**
 * 用户ID
 *
 * @author chenzhihao
 * @date 2023-10-09 13:50
 */
public class UserId extends ID<Long> {

    private static final long serialVersionUID = -438236367286944460L;

    public UserId(@NonNull Long id) {
        super(id);
    }

    @Override
    protected Long generate() {
        return Instant.now().toEpochMilli();
    }
}
