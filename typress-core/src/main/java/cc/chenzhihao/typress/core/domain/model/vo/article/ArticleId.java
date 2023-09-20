package cc.chenzhihao.typress.core.domain.model.vo.article;

import cc.chenzhihao.typress.core.domain.model.vo.ID;
import lombok.NonNull;

import java.time.Instant;

/**
 * 文章ID
 *
 * @author chenzhihao
 * @date 2023-09-19 19:47
 */
public class ArticleId extends ID<Long> {

    private static final long serialVersionUID = 4206333533624518864L;

    public ArticleId() {
    }

    public ArticleId(@NonNull Long id) {
        super(id);
    }

    @Override
    protected Long generate() {
        // 当前毫秒级时间戳作为文章ID
        return Instant.now().toEpochMilli();
    }
}
