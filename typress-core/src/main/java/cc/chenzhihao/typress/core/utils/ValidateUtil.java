package cc.chenzhihao.typress.core.utils;

import cc.chenzhihao.typress.core.domain.component.verify.Verifiable;
import cc.chenzhihao.typress.core.domain.exception.ValidateFailedException;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 验证工具
 *
 * @author chenzhihao
 * @date 2023-09-19 16:52
 */
public class ValidateUtil {
    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();

    /**
     * 执行复杂对象参数校验
     * <p>
     * 优先使用Springboot Validation进行参数校验，若无异常且对象实现了{@link Verifiable}接口，则调用 {@link Verifiable#validate()} 方法进行验证
     *
     * @param obj    被验证对象
     * @param <T>    被验证对象类型
     * @param groups 指定要验证的分组列表
     * @throws ValidateFailedException 校验失败抛出异常
     */
    public static <T> void validate(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> validateResult = FACTORY.getValidator().validate(obj, groups);
        List<String> errMessages = validateResult.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(errMessages)) {
            throw new ValidateFailedException(String.join(";", errMessages));
        }

        if (obj instanceof Verifiable) {
            ((Verifiable) obj).validate();
        }
    }

}
