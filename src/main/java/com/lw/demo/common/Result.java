package com.lw.demo.common;

import com.lw.demo.common.enums.ReturnCodeEnum;
import lombok.Data;

@Data
public class Result {
    private int code;//返回码
    private String message;//返回消息
    private Object obj;//返回数据
    private boolean success;//是否成功

    /**
     * 成功返回不带任何信息的
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(ReturnCodeEnum.SUCCESS.getCode());
        result.setMessage(ReturnCodeEnum.SUCCESS.getMessage());
        result.setSuccess(true);
        return result;
    }

    /**
     * 成功返回带信息的
     * @return
     */
    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(ReturnCodeEnum.SUCCESS.getCode());
        result.setMessage(ReturnCodeEnum.SUCCESS.getMessage());
        result.setObj(obj);
        result.setSuccess(true);
        return result;
    }

    /**
     *返回默认的错误信息
     * @return
     */
    public static Result fail(){
        Result result = new Result();
        result.setCode(ReturnCodeEnum.FAIL.getCode());
        result.setMessage(ReturnCodeEnum.FAIL.getMessage());
        result.setSuccess(false);
        return result;
    }

    /**
     *返回错误信息
     * @return
     */
    public static Result fail(String message){
        Result result = new Result();
        result.setCode(ReturnCodeEnum.FAIL.getCode());
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }


}
