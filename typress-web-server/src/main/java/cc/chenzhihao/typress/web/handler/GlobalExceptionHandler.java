package cc.chenzhihao.typress.web.handler;

import cc.chenzhihao.typress.commons.exception.BusinessException;
import cc.chenzhihao.typress.commons.model.dto.Result;
import cc.chenzhihao.typress.commons.model.dto.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器
 *
 * @author chenzhihao
 * @date 2023-10-07 14:50
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常，抛出错误码和错误信息
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> handlerBusinessException(BusinessException e) {
        log.warn("BusinessException||msg={}", e.getMessage());
        return Result.as(e.getErrorCode(), e.getErrorMsg());
    }


    /**
     * 未找到处理器的404异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<?> handlerNoHandlerFoundException(NoHandlerFoundException e) {
        log.warn("BusinessException||msg={}", e.getMessage());
        return Result.as(Status.RESOURCE_NOT_FOUND_ERROR, String.format("url not found, method=%s, url=%s", e.getHttpMethod(), e.getRequestURL()));
    }

    /******************************************
     * 兜底异常，所有其他异常均定义在该处理器之前！！！
     ******************************************/
    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e) {
        log.error("unknown_exception||exception_type={}||msg={}", e.getClass().getName(), e.getMessage(), e);
        return Result.as(Status.SYSTEM_ERROR);
    }
}
