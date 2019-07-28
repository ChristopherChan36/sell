package com.pisces.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Title: OrderForm </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-5 23:41
 */
@Data
public class OrderForm {

    /**
     * 买家姓名.
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号.
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址.
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid.
     */
    @NotEmpty(message = "买家微信openid不能为空")
    private String openid;

    /**
     * 买家购物车.
     */
    @NotEmpty(message = "购物车信息不能为空")
    private String items;
}
