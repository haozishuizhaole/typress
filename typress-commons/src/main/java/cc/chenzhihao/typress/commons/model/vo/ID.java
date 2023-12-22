package cc.chenzhihao.typress.commons.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * 唯一标识
 *
 * @author chenzhihao
 * @date 2023-09-14 20:45
 */
@Data
@EqualsAndHashCode
public abstract class ID<T> implements Identity<T> {

    private static final long serialVersionUID = 8753279548750008142L;

    private T id;

    public ID() {
        id = generate();
    }

    public ID(@NonNull T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }

    /**
     * 生成ID数据
     *
     * @return ID数据
     */
    protected abstract T generate();

}