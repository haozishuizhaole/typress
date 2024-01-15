package cc.chenzhihao.typress.core.domain.article.vo;

import cc.chenzhihao.typress.commons.model.vo.ID;
import lombok.NonNull;

import java.time.Instant;

/**
 * 文章ID
 *
 * @author chenzhihao
 * @date 2024-01-12 17:30
 */
public class ArticleID extends ID<Long> {

    private static final long serialVersionUID = 720302328576644224L;

    public ArticleID() {
    }

    public ArticleID(@NonNull Long id) {
        super(id);
    }

    @Override
    protected Long generate() {
        return Instant.now().getEpochSecond();
    }
}
