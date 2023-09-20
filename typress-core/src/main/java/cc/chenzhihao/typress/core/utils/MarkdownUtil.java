package cc.chenzhihao.typress.core.utils;

import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Arrays;

/**
 * Markdown 工具
 *
 * @author chenzhihao
 * @date 2023-09-19 19:53
 */
public class MarkdownUtil {

    private static final Parser PARSER;

    private static final HtmlRenderer HTML_RENDER;

    static {
        DataHolder options = new MutableDataSet()
                .set(Parser.EXTENSIONS, Arrays.asList(
                        GitLabExtension.create(),
                        AutolinkExtension.create(),
                        TablesExtension.create(),
                        StrikethroughExtension.create()
                ))
                .toImmutable();

        PARSER = Parser.builder(options).build();
        HTML_RENDER = HtmlRenderer.builder(options).build();
    }

    /**
     * Markdown转换为
     *
     * @param markdown Markdown文本
     * @return HTML文本
     */
    public static String rendersAsHtml(String markdown) {
        return HTML_RENDER.render(PARSER.parse(markdown));
    }

}
