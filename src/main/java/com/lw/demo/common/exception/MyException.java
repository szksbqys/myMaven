package com.lw.demo.common.exception;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class MyException extends Exception{
    /**
     * 自定义异常码
     */
    private int code;
    /**
     * 自定义异常信息
     */
    private String msg;

    public MyException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
