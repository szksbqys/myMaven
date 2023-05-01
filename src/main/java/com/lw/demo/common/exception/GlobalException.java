package com.lw.demo.common.exception;

import com.lw.demo.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一注解拦截
 */
@ControllerAdvice
public class GlobalException {
    /**
     * 拦截自定义异常
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myException(MyException myException){
        return Result.fail(myException.getMsg());
    }

    /**
     * 拦截系统异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result myException(Exception exception){
        return Result.fail(exception.getMessage());
    }
}
