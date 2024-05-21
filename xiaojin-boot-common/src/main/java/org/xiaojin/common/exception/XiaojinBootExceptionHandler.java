package org.xiaojin.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.xiaojin.common.base.Result;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName XiaojinBootExceptionHandler.java
 * @Description TODO
 * @createTime 2024年05月21日 10:50:00
 */
@RestControllerAdvice
@Slf4j
public class XiaojinBootExceptionHandler {

    /**
     * 自定义异常
     */
    @ExceptionHandler(XiaojinBootException.class)
    public Result<?> handleXiaojinBootException(XiaojinBootException e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getErrCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<?> handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<?> handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return Result.error("数据库中已存在该记录");
    }

}
