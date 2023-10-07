package cc.chenzhihao.typress.core.service.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果
 *
 * @author chenzhihao
 * @date 2023-09-18 20:52
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;


    public Result(String code, String msg) {
        this(code, msg, null);
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("code", code);
        m.put("msg", msg);
        m.put("data", data);
        return m;
    }
}
