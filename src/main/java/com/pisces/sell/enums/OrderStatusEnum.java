package com.pisces.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Title: OrderStatusEnum </p>
 * <p>Description: 订单状态枚举类 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 21:47
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements BaseStatusEnum {

    NEW(0, "新下单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;
}
