package cc.chenzhihao.typress.core.domain.model.entity;

import cc.chenzhihao.typress.core.domain.model.entity.base.Entity;
import cc.chenzhihao.typress.core.domain.model.vo.MarkdownText;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;
import cc.chenzhihao.typress.core.domain.model.vo.article.ArticleId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章
 *
 * @author chenzhihao
 * @date 2023-09-19 19:54
 */
@Data
@NoArgsConstructor
public class Article implements Entity<ArticleId> {

    private static final long serialVersionUID = 4484022689945654223L;

    /**
     * 文章ID
     */
    private ArticleId articleId;

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

    public Article(ArticleId articleId, String articleTitle, MarkdownText articleContent) {
        this(articleId, articleTitle, articleContent, new Timestamp(), new Timestamp());
    }

    public Article(ArticleId articleId, String articleTitle, MarkdownText articleContent, Timestamp createTime, Timestamp updateTime) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public ArticleId getId() {
        return articleId;
    }
}
