package com.example.labdemo.util;

public class BaseException extends Exception{
    private Integer code;
    public BaseException(String message) {
        super(message);
        this.code = ResultEnum.SEVER_INTERVAL_ERROR.getCode();
    }
    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code= resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
