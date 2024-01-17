package cc.chenzhihao.typress.commons.model.vo.databinder;

import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.commons.util.JSONUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.Objects;

/**
 * @author chenzhihao
 * @date 2024-01-10 19:35
 */
public class TimestampDataBinderTest {

    @Test
    public void serialize_case1() {
        Timestamp timestamp = null;
        System.out.println(JSONUtil.serialize(timestamp));
    }

    @Test
    public void serialize_case2() {
        class Demo {
            Timestamp timestamp;

            public Timestamp getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(Timestamp timestamp) {
                this.timestamp = timestamp;
            }
        }
        Demo demo = new Demo();
        System.out.println(JSONUtil.serialize(demo));
    }

    @Test
    public void serialize_case3() {
        class Demo {
            Timestamp timestamp;

            public Demo(Timestamp timestamp) {
                this.timestamp = timestamp;
            }

            public Timestamp getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(Timestamp timestamp) {
                this.timestamp = timestamp;
            }
        }
        Demo demo = new Demo(new Timestamp(12345678654L));
        System.out.println(JSONUtil.serialize(demo));
    }

    @Data
    @EqualsAndHashCode
    static class Demo {
        Long timestamp;
    }
    @Test
    public void serialize_case4() {

        Demo demo = new Demo();
        demo.setTimestamp(1705394319074L);
        System.out.println(JSONUtil.serialize(demo));

        String json = "{\"timestamp\":\"1705394319074\"}";
        Demo demo1 = JSONUtil.deserialize(json, Demo.class);
        System.out.println(demo1);
        assert Objects.equals(demo1, demo);

    }
}