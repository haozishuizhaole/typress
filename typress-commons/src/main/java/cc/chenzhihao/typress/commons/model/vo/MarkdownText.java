package cc.chenzhihao.typress.commons.model.vo;

import cc.chenzhihao.typress.commons.util.MarkdownUtil;
import lombok.ToString;

/**
 * 基于Markdown的文本类型
 *
 * @author chenzhihao
 * @date 2024-01-12 17:38
 */
@ToString
public class MarkdownText extends Text {

    private static final long serialVersionUID = -2549285433682394257L;

    public MarkdownText(String originalText, String renderedText) {
        super(originalText, renderedText);
    }

    public MarkdownText(String originalText) {
        super(originalText);
    }

    @Override
    public String rendering(String originalText) {
        return MarkdownUtil.rendersAsHtml(originalText);
    }
}