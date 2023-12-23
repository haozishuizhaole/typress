package cc.chenzhihao.typress.commons.model.vo.databinder;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

/**
 * @author chenzhihao
 * @date 2023-12-23 15:14
 */
public interface DataBinder<T> {

    JsonSerializer<T> getJsonSerializer();

    JsonDeserializer<T> getJsonDeserializer();
}
