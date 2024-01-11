package cc.chenzhihao.typress.core.component.condition;

import cc.chenzhihao.typress.commons.component.condition.ConditionGenerator;
import cc.chenzhihao.typress.core.domain.config.entity.Config;

import java.util.Collections;

/**
 * 生成条件类文件
 *
 * @author chenzhihao
 * @date 2023-12-23 23:23
 */
class Generator {
    private Generator() {
    }

    public static void main(String[] args) throws Exception {
        String packageName = "cc.chenzhihao.typress.core.component.condition";
        ConditionGenerator.of("src/main/java", packageName, Collections.singletonList(Config.class)).generate();
    }
}
