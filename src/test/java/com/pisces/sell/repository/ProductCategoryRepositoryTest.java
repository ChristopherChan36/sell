package com.pisces.sell.repository;

import com.pisces.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> categoryTypeList = Arrays.asList(1, 2, 3);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(categoryTypeList);

        Assert.assertNotEquals(0, productCategoryList.size());
    }
}