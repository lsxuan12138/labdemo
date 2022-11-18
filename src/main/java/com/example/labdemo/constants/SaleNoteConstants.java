package com.example.labdemo.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 14:30
 */
public class SaleNoteConstants {
    /**
     * 未编辑
     */
    public static final String STAGE_TO_BE_EDITED="未编辑";
    /**
     * 待审核
     */
    public static final String STAGE_TO_BE_AUDITED = "待审核";
    /**
     * 待付款
     */
    public static final String STAGE_TO_BE_PAID="待付款";
    /**
     * 已付款
     */
    public static final String STAGE_HAVE_PAID = "已付款";
    /**
     * 已退款
     */
    public static final String STAGE_HAVE_REFUNDED = "已退款";

    private static final Map<String,Integer> STAGE_MAP;
    static {
        STAGE_MAP = new HashMap<>();
        STAGE_MAP.put(STAGE_TO_BE_EDITED,1);
        STAGE_MAP.put(STAGE_TO_BE_AUDITED,2);
        STAGE_MAP.put(STAGE_TO_BE_PAID,3);
        STAGE_MAP.put(STAGE_HAVE_PAID,4);
        STAGE_MAP.put(STAGE_HAVE_REFUNDED,5);
    }
    public static boolean stageCompare(String currStage, String targetStage){
        return STAGE_MAP.get(currStage)<STAGE_MAP.get(targetStage);
    }
}
