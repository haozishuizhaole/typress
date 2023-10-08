package cc.chenzhihao.typress.core.domain.model.vo.session;

import cc.chenzhihao.typress.core.domain.model.vo.ID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;

/**
 * 会话ID
 *
 * @author chenzhihao
 * @date 2023-10-08 15:01
 */
public class SessionId extends ID<String> {

    private static final long serialVersionUID = 6209889346077850350L;

    private static final Key KEY = Keys.hmacShaKeyFor("type_press_system_json_web_token_key".getBytes(StandardCharsets.UTF_8));

    @Override
    protected String generate() {
        return Jwts.builder().setSubject(String.valueOf(Instant.now().toEpochMilli())).signWith(KEY).compact();
    }

    /**
     * 校验会话ID
     *
     * @param sessionId 会话ID
     */
    public static boolean validate(String sessionId) {
        String subject;
        try {
            subject = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(sessionId)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return false;
        }

        if (StringUtils.isBlank(subject)) {
            return false;
        }

        return StringUtils.isNumeric(subject);
    }
}
