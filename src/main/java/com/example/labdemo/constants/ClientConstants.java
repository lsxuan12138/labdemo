package com.example.labdemo.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 15:00
 */
public class ClientConstants {
    /**
     * 批发客户
     */
    public static final String TYPE_WHOLESALES = "批发客户";
    /**
     * 零售客户
     */
    public static final String TYPE_RETAILS = "零售客户";
    private static final Map<String,String> TYPE_MAP;
    static {
        TYPE_MAP = new HashMap<>();
        TYPE_MAP.put("0",TYPE_WHOLESALES);
        TYPE_MAP.put("1",TYPE_RETAILS);
    }
    public static String changeType(String type){
        return TYPE_MAP.get(type);
    }
}
