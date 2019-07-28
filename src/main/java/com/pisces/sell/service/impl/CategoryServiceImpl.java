package com.pisces.sell.service.impl;

import com.pisces.sell.entity.ProductCategory;
import com.pisces.sell.repository.ProductCategoryRepository;
import com.pisces.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: CategoryServiceImpl </p>
 * <p>Description: 类目业务实现类 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-27 22:54
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
