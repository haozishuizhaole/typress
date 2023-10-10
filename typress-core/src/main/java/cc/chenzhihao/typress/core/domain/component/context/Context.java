package cc.chenzhihao.typress.core.domain.component.context;

import cc.chenzhihao.typress.core.domain.model.entity.Session;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 上下文
 *
 * @author chenzhihao
 * @date 2023-10-09 20:54
 */
public class Context {

    private static final String MDC_TRACE_ID = "trace_id";

    /**
     * 自定义参数
     */
    private static final ThreadLocal<Map<String, Object>> VARIABLES = new ThreadLocal<>();

    /**
     * 用户会话
     */
    private static final ThreadLocal<Session> SESSION = new ThreadLocal<>();

    public static void put(String key, Object value) {
        getVariables().put(key, value);
    }

    public static Object get(String key) {
        return getVariables().get(key);
    }

    public static Session getSession() {
        return SESSION.get();
    }

    public static void setSession(Session session) {
        SESSION.remove();
        Context.SESSION.set(session);
    }

    public static String getTraceId() {
        String traceId = MDC.get(MDC_TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            MDC.put(MDC_TRACE_ID, (traceId = UUID.randomUUID().toString().replace("-", "")));
        }
        return traceId;
    }

    public static void setTraceId(String traceId) {
        MDC.put(MDC_TRACE_ID, traceId);
    }

    public static void clear() {
        SESSION.remove();
        MDC.clear();
        VARIABLES.remove();
    }

    private static Map<String, Object> getVariables() {
        Map<String, Object> variables = VARIABLES.get();
        if (Objects.isNull(variables)) {
            VARIABLES.set(variables = new HashMap<>());
        }
        return variables;
    }
}
