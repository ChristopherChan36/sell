package com.pisces.sell.service;

import com.pisces.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>Title: OrderService </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 22:40
 */
public interface OrderService {

    /**
     * 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);
}
