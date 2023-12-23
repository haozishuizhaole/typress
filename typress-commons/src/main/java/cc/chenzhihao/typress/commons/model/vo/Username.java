package cc.chenzhihao.typress.commons.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户名
 *
 * @author chenzhihao
 * @date 2023-12-23 14:39
 */
@Data
public class Username implements Serializable {

    private static final long serialVersionUID = 1134831783468912275L;

    private String value;

    public Username() {
    }

    public Username(String value) {
        this.value = value;
    }

}
