package cc.chenzhihao.typress.commons.util;

import cc.chenzhihao.typress.commons.model.vo.Password;
import cc.chenzhihao.typress.commons.model.vo.Username;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author chenzhihao
 * @date 2023-12-23 15:32
 */
public class JSONUtilTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private Username username;
        private Password password;
        private Integer age;
    }

    @Test
    public void test_serialize() {
        User user = new User(new Username("chenzhihao"), new Password("123456", false), 21);
        String result = JSONUtil.serialize(user);
        String target = "{\"username\":\"chenzhihao\",\"password\":\"123456\",\"age\":21}";
        Assert.assertEquals(result, target);
    }

    @Test
    public void test_deserialize_String_Class() {
        String json = "{\"username\":\"chenzhihao\",\"password\":\"123456\",\"age\":21}";
        User result = JSONUtil.deserialize(json, User.class);
        User target = new User(new Username("chenzhihao"), new Password("123456", false), 21);
        Assert.assertEquals(result, target);
    }

    @Test
    public void test_deserialize_String_TypeReference() {
        String json = "[{\"username\":\"chenzhihao\",\"password\":\"123456\",\"age\":21}]";
        List<User> result = JSONUtil.deserialize(json, new TypeReference<List<User>>() {
        });
        List<User> target = Collections.singletonList( new User(new Username("chenzhihao"), new Password("123456", false), 21));
        Assert.assertEquals(result, target);
    }

    @Test
    public void read() {
        String json = "[{\"username\":\"chenzhihao\",\"password\":\"123456\",\"age\":21}]";
        JsonNode result = JSONUtil.read(json);
        Assert.assertTrue(result.isArray());
        Assert.assertNotNull(result.get(0));
        JsonNode jsonNode = result.get(0);
        Assert.assertTrue(jsonNode.isObject());
        Assert.assertEquals(jsonNode.get("username").textValue(), "chenzhihao");
        Assert.assertEquals(jsonNode.get("password").textValue(), "123456");
        Assert.assertEquals(jsonNode.get("age").intValue(), 21);
    }
}
