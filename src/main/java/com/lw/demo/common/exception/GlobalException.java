package com.lw.demo.common.exception;

import com.lw.demo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一注解拦截
 */
@ControllerAdvice
@Slf4j
public class GlobalException {
    /**
     * 拦截自定义异常
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myException(MyException myException){
        log.error("发生自定义异常，原因",myException);
        return Result.fail(myException.getMsg());
    }

    /**
     * 拦截系统异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result myException(Exception exception){
        log.error("发生系统异常，原因",exception);
        return Result.fail(exception.getMessage());
    }
}
