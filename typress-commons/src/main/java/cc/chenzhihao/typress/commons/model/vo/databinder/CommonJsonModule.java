package cc.chenzhihao.typress.commons.model.vo.databinder;

import cc.chenzhihao.typress.commons.model.vo.Password;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;
import cc.chenzhihao.typress.commons.model.vo.Username;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author chenzhihao
 * @date 2023-12-23 15:20
 */
public class CommonJsonModule extends SimpleModule {
    private static final long serialVersionUID = -1778724438129703675L;

    private final PasswordDataBinder passwordDataBinder = PasswordDataBinder.getInstance();
    private final UsernameDataBinder usernameDataBinder = UsernameDataBinder.getInstance();

    private final TimestampDataBinder timestampDataBinder = TimestampDataBinder.getInstance();

    public CommonJsonModule() {
        addSerializer();
        addDeserializer();
    }

    private void addSerializer() {
        addSerializer(Password.class, passwordDataBinder.getJsonSerializer());
        addSerializer(Username.class, usernameDataBinder.getJsonSerializer());
        addSerializer(Timestamp.class, timestampDataBinder.getJsonSerializer());
    }

    private void addDeserializer() {
        addDeserializer(Password.class, passwordDataBinder.getJsonDeserializer());
        addDeserializer(Username.class, usernameDataBinder.getJsonDeserializer());
        addDeserializer(Timestamp.class, timestampDataBinder.getJsonDeserializer());
    }

}
