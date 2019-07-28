package com.pisces.sell.converter;

import com.pisces.sell.dto.OrderDTO;
import com.pisces.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: OrderMaster2OrderDTOConverter </p>
 * <p>Description: 订单转订单DTO </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-5 21:38
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        List<OrderDTO> orderDTOList = orderMasterList.stream()
                .map(OrderMaster2OrderDTOConverter::convert)
                .collect(Collectors.toList());
        return orderDTOList;
    }
}
