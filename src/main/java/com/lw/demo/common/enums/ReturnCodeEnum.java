package com.lw.demo.common.enums;

public enum ReturnCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    private int code;
    private String message;

    ReturnCodeEnum() {
    }

    ReturnCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
