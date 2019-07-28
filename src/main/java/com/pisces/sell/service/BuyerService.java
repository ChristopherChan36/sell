package com.pisces.sell.service;

import com.pisces.sell.dto.OrderDTO;

/**
 * <p>Title: BuyerService </p>
 * <p>Description: 买家 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-7 22:04
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);

}
