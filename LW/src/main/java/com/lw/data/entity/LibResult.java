package com.lw.data.entity;


import com.lw.data.enums.ResultStatusEnum;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 接口返回结果
 * @author wqy
 * @create 2018/1/9
 */
public class LibResult<T> {

    private Integer status;

    private String message;

    private T data;

    private boolean error;

    public static LibResult returnSuccess(){
        LibResult result=new LibResult();
        result.setStatus(ResultStatusEnum.SUCCESS.getValue());
        result.setData(new HashMap());
        return result;
    }

    public static LibResult returnSuccess(String message){
        LibResult result=new LibResult();
        result.setStatus(ResultStatusEnum.SUCCESS.getValue());
        result.setData(new HashMap());
        result.setMessage(message);
        return result;
    }

    public static LibResult returnError(String message){
        LibResult result=new LibResult();
        result.setStatus(ResultStatusEnum.FAILED.getValue());
        result.setData(null);
        result.setMessage(message);
        return result;
    }
    public static LibResult returnPwdError(String message){
        LibResult result=new LibResult();
        result.setStatus(ResultStatusEnum.PWDERREOR.getValue());
        result.setData(null);
        result.setMessage(message);
        return result;
    }


    public static LibResult returnLibResult(ResultStatusEnum resultStatusEnum){
        LibResult result=new LibResult();
        result.setStatus(resultStatusEnum.SUCCESS.getValue());
        result.setData(new HashMap());
        return result;
    }

    public static LibResult returnLibResult(ResultStatusEnum resultStatusEnum,Object data){
        LibResult result=new LibResult();
        result.setStatus(resultStatusEnum.SUCCESS.getValue());
        result.setData(data);
        return result;
    }

    public static LibResult returnLibResult(ResultStatusEnum resultStatusEnum,Object data,String message){
        LibResult result=new LibResult();
        result.setStatus(resultStatusEnum.SUCCESS.getValue());
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}