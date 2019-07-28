package com.pisces.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_NOT_SUFFICIENT(101, "商品库存不足"),
    ORDER_NOT_EXIST(102, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(103, "订单详情信息不存在"),
    ORDER_STATUS_ERROR(104, "订单状态不正确"),
    ORDER_UPDATE_FAIL(105, "订单更新失败"),
    ORDER_DETAIL_EMPTY(106, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(107, "订单支付状态不正确"),
    CART_EMPTY(108, "购物车不能为空"),
    ORDER_OWNER_ERROR(109, "该订单不属于当前用户"),
    WECHAT_MP_ACCOUNT_AUTHORIZE_ERROR(201, "微信公众账号方面错误");

    private Integer code;

    private String message;
}
