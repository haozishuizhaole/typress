package cc.chenzhihao.typress.core.domain.model.vo;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

/**
 * 密码
 *
 * @author chenzhihao
 * @date 2023-09-22 16:13
 */
@Data
public class Password implements Serializable {

    private static final long serialVersionUID = 5786153364371127739L;

    private String value;

    public Password() {
    }

    /**
     * 构建密码
     *
     * @param originPassword 明文密码
     */
    public Password(String originPassword) {
        this.value = encode(originPassword);
    }

    /**
     * 密码加密
     *
     * @param originPassword 原始密码
     * @return 加密密码
     */
    protected String encode(String originPassword) {
        return DigestUtils.sha512Hex(originPassword);
    }
}
