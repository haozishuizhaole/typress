package cc.chenzhihao.typress.server.component.handler;

import cc.chenzhihao.typress.core.domain.exception.base.BusinessException;
import cc.chenzhihao.typress.core.service.result.ErrorCode;
import cc.chenzhihao.typress.core.service.result.Result;
import cc.chenzhihao.typress.core.service.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return ResultUtil.as(e.getErrorCode(), e.getErrorMsg());
    }
    
    /******************************************
     * 兜底异常，所有其他异常均定义在该处理器之前！！！
     ******************************************/
    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e) {
        log.error("unknown_exception||exception_type={}||msg={}", e.getClass().getName(), e.getMessage(), e);
        return ResultUtil.as(ErrorCode.SYSTEM_ERROR);
    }
}
