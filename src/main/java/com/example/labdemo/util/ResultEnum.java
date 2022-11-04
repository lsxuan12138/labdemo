package com.example.labdemo.util;

public enum ResultEnum {

    SUCCESS(200,"OK"),
    SEVER_INTERVAL_ERROR(500,"服务器内部错误"),
    NUMBER_FORMAT_ERROR(14000,"number format error"),

    CLIENT_NAME_IS_REPEATED(14001,"client name is repeated"),
    CLIENT_INSERT_ERROR(14002,"client insert error"),

    PRODUCT_INSERT_ERROR(14003,"product insert error"),

    PRODUCT_DELETE_ERROR(14004,"product delete error"),

    SALE_NOTE_STAGE_ERROR(14005,"sale note stage error"),

    PRODUCT_IS_NOT_ENOUGH(14006,"some products is not enough"),

    ;
    private final Integer code;

    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
