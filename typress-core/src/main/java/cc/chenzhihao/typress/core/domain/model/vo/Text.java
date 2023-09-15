package cc.chenzhihao.typress.core.domain.model.vo;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文本
 *
 * @author chenzhihao
 * @date 2023-09-14 20:46
 */
@Getter
@ToString
public abstract class Text implements Serializable {

    private static final long serialVersionUID = 9132872679831439944L;

    /**
     * 原始文本
     */
    private final String originalText;

    /**
     * 渲染后的文本
     */
    private final String renderedText;

    public Text(String originalText, String renderedText) {
        this.originalText = originalText;
        this.renderedText = renderedText;
    }

    public Text(String originalText) {
        this.originalText = originalText;
        this.renderedText = rendering(originalText);
    }

    /**
     * 渲染文本
     *
     * @param originalText 原始文本
     * @return 渲染后的文本
     */
    public abstract String rendering(String originalText);
}
