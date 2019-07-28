package com.pisces.sell.repository;

import com.pisces.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>Title: ProductCategoryRepository </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-26 23:19
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据商品类别的类目编号集合查询所有的商品类目信息.
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
