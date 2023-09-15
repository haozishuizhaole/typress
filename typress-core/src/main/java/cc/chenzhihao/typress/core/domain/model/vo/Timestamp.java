package cc.chenzhihao.typress.core.domain.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * 时间戳，默认生成当前时间的毫秒级时间戳
 *
 * @author chenzhihao
 * @date 2023-09-14 20:30
 */
@Data
public class Timestamp implements Serializable {

    private static final long serialVersionUID = 4432620151152577722L;

    private long value;

    public Timestamp() {
        value = Instant.now().toEpochMilli();
    }

    public Timestamp(long value) {
        this.value = value;
    }
}
