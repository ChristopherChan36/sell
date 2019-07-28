package com.pisces.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>Title: CartDTO </p>
 * <p>Description: 购物车 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 23:51
 */
@Data
@AllArgsConstructor
public class CartDTO {

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 数量.
     */
    private Integer productQuantity;
}
