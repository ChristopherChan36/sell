package com.pisces.sell.repository;

import com.pisces.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>Title: ProductInfoRepository </p>
 * <p>Description: 商品信息Repository </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-27 23:11
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
