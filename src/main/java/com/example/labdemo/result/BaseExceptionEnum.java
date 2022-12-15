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

    NUMBER_FORMAT_ERROR("14000","数字格式错误"),

    CLIENT_NAME_IS_REPEATED("14001","客户名字重复"),
    CLIENT_INSERT_ERROR("14002","客户增加错误"),

    PRODUCT_INSERT_ERROR("14003","商品增加错误"),

    PRODUCT_DELETE_ERROR("14004","商品删除错误"),

    SALE_NOTE_STAGE_ERROR("14005","销售单阶段错误"),

    PRODUCT_IS_NOT_ENOUGH("14006","该仓库商品库存不足"),

    PRODUCT_UPDATE_ERROR("14007","商品更新错误"),

    LOGIN_ERROR("14008","登录失败"),

    TOKEN_ERROR("14009","非法token"),

    WITHOUT_LOGIN_ERROR("14010","用户未登录"),

    USER_NO_EXIST("14011","用户不存在"),

    STAGE_ERROR("14012","阶段错误"),

    USER_INSERT_ERROR("14013","该用户名已被占用"),

    USER_HAS_ALIVE("14014","该用户已激活"),

    CLIENT_NOT_EXIST("14015","客户不存在"),

    CLIENT_CANT_DELETE("14016","该客户名下已有订单，禁止删除"),
    CLIENT_DELETE_ERROR("14017","客户删除失败"),

    PRODUCT_NOT_EXIST("14018","产品不存在"),

    PRODUCT_CANT_DELETE("14019","该产品已存在某些销售单/进货单/调货单中，禁止删除"),

    STORE_NOT_EXIST("14020","仓库不存在"),

    STORE_NOT_EMPTY("14021","该仓库不为空"),
    STORE_CANT_DELETE("14022","该仓库已存在某些销售单/进货单/调货单中，禁止删除"),

    PASSWORD_NOT_MATCH("14023","密码错误"),

    USER_HAS_NOT_ALIVE("14024","该用户未激活"),
    PRODUCT_CANT_DELETE_TWO("14025","禁止删除该商品，请先清空库存"),
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
