package com.pisces.sell.service;

import com.pisces.sell.dto.CartDTO;
import com.pisces.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>Title: ProductService </p>
 * <p>Description: 商品业务接口 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-27 23:33
 */
public interface ProductService {

    ProductInfo findOne(String produtId);

    /**
     * 查询所有在架的商品列表
     *
     * @return List<ProductInfo>
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
