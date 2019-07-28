package com.pisces.sell.service;

import com.pisces.sell.entity.ProductCategory;

import java.util.List;

/**
 * <p>Title: CategoryService </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-27 22:50
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
