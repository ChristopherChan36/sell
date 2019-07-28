package com.pisces.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pisces.sell.dto.OrderDTO;
import com.pisces.sell.entity.OrderDetail;
import com.pisces.sell.enums.ResultEnum;
import com.pisces.sell.exception.SellException;
import com.pisces.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: OrderForm2OrderDTOConverter </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-6 22:02
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    /**
     * 将前台的Form表单验证封装类 转化为 OrderDTO 订单转换类
     *
     * @param orderForm
     * @return
     */
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            // 将前台传输的 订单商品详情Json信息 转换为订单实体类
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
