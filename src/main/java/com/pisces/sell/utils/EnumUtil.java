package com.pisces.sell.utils;

import com.pisces.sell.enums.BaseStatusEnum;
import com.pisces.sell.enums.OrderStatusEnum;

/**
 * <p>Title: EnumUtil </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-4-14 23:37
 */
public class EnumUtil {

    private static <T extends BaseStatusEnum> T stateOf(Class<T> clazz, Integer code) {
        T[] constants = clazz.getEnumConstants();
        for (T constant : constants) {
            if (constant.getCode().equals(code)) {
                return constant;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OrderStatusEnum orderStatusEnum = EnumUtil.stateOf(OrderStatusEnum.class, 0);
        System.out.println(orderStatusEnum);
    }
}
