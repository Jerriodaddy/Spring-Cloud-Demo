package com.icewould.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenzhe
 */

public enum AdminDivLevel {
    /**
     * 省级
     */
    PROVINCE(0),
    /**
     * 地级
     */
    CITY(1),
    /**
     * 县级
     */
    COUNTY(2),
    /**
     * 乡级
     */
    TOWN(3);

    /**
     * 键值对枚举类的Map
     */
    private static final Map<Integer, AdminDivLevel> BY_LABEL = new HashMap<>();

    static {
        for (AdminDivLevel e: values()) {
            BY_LABEL.put(e.value, e);
        }
    }

    /**
     * 获取键值对应的枚举类
     */
    public static AdminDivLevel getEnum(int value) {
        return BY_LABEL.get(value);
    }

    /**
     * 数据库中的键值
     */
    private final int value;
    AdminDivLevel(int value) {
        this.value = value;
    }

    /**
     * 获取枚举类对应的键值
     */
    public int getValue(){
        return value;
    }
}
