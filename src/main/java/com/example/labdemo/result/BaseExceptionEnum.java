package com.example.labdemo.result;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-11 22:12
 */
public enum BaseExceptionEnum implements BaseErrorInfoInterface{
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    FORBIDDEN("403","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    NUMBER_FORMAT_ERROR("14000","number format error"),

    CLIENT_NAME_IS_REPEATED("14001","client name is repeated"),
    CLIENT_INSERT_ERROR("14002","client insert error"),

    PRODUCT_INSERT_ERROR("14003","product insert error"),

    PRODUCT_DELETE_ERROR("14004","product delete error"),

    SALE_NOTE_STAGE_ERROR("14005","sale note stage error"),

    PRODUCT_IS_NOT_ENOUGH("14006","some products is not enough"),

    PRODUCT_UPDATE_ERROR("14007","product insert error"),

    LOGIN_ERROR("14008","登录失败"),

    TOKEN_ERROR("14009","非法token"),

    WITHOUT_LOGIN_ERROR("14010","用户未登录"),

    ;

    /**
     * 错误码
     */
    private final String resultCode;

    /**
     * 错误描述
     */
    private final String resultMsg;

    BaseExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
