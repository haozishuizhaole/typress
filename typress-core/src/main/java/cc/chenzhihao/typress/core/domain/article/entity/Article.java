package cc.chenzhihao.typress.core.domain.article.entity;

import cc.chenzhihao.typress.commons.model.entity.Entity;
import cc.chenzhihao.typress.commons.model.vo.MarkdownText;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章
 *
 * @author chenzhihao
 * @date 2024-01-12 17:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Entity<ArticleID> {

    private static final long serialVersionUID = 7373285088849946273L;

    /**
     * 文章ID
     */
    private ArticleID articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private MarkdownText articleContent;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;


    @Override
    public ArticleID getId() {
        return null;
    }
}
