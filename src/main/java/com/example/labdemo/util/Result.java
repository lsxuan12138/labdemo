package com.example.labdemo.util;

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
        ResultEnum resultEnum = ResultEnum.SUCCESS;
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
    public Result(Object data) {
        ResultEnum resultEnum = ResultEnum.SUCCESS;
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }
    public Result(BaseException e){
        this.code=e.getCode();
        this.msg=e.getMessage();
    }
    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
    public Result(ResultEnum resultEnum,Object data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
