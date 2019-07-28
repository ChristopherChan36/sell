package com.pisces.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态枚举类
 *
 * @author christopher
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {

    UP(0, "在架"), DOWN(1, "下架");

    private Integer code;

    private String message;


}
