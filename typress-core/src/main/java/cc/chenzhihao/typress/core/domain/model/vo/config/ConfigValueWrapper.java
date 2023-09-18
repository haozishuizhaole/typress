package cc.chenzhihao.typress.core.domain.model.vo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 配置值包装器
 *
 * @author chenzhihao
 * @date 2023-09-14 20:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigValueWrapper<T> implements Serializable {

    private static final long serialVersionUID = -661606423607667512L;

    /**
     * 配置值
     */
    private T value;

}
