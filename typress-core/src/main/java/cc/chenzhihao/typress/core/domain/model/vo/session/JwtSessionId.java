package cc.chenzhihao.typress.core.domain.model.vo.session;

import cc.chenzhihao.typress.core.domain.model.vo.ID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;

/**
 * 基于JWT的SessionID实现
 *
 * @author chenzhihao
 * @date 2023-10-08 17:31
 */
public class JwtSessionId extends ID<String> implements SessionId {

    private static final long serialVersionUID = 3170789521670005563L;

    private static final Key KEY = Keys.hmacShaKeyFor("type_press_system_json_web_token_key".getBytes(StandardCharsets.UTF_8));

    @Override
    protected String generate() {
        return Jwts.builder().setSubject(String.valueOf(Instant.now().toEpochMilli())).signWith(KEY).compact();
    }

    @Override
    public void validate(String sessionId) {
        String subject;
        try {
            subject = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(sessionId)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("jwt token validate failed", e);
        }

        if (!StringUtils.isNumeric(subject)) {
            throw new RuntimeException("jwt token subject is not numeric");
        }
    }
}
