package com.pisces.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Title: ProductVO </p>
 * <p>Description: 商品信息，包含类目信息 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-28 22:12
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
