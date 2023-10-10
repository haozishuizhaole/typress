package cc.chenzhihao.typress.core.domain.model.vo;

import cc.chenzhihao.typress.core.domain.exception.ValidateFailedException;
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

    public ID(@NonNull T id) throws ValidateFailedException {
        validate(id);
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

    /**
     * 验证ID合法性
     */
    protected void validate(T id) throws ValidateFailedException {
    }

    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }
}