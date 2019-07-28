package com.pisces.sell.controller;

import com.pisces.sell.VO.ProductInfoVO;
import com.pisces.sell.VO.ProductVO;
import com.pisces.sell.VO.ResultVO;
import com.pisces.sell.entity.ProductCategory;
import com.pisces.sell.entity.ProductInfo;
import com.pisces.sell.service.CategoryService;
import com.pisces.sell.service.ProductService;
import com.pisces.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: BuyerProductController </p>
 * <p>Description: 买家端商品API </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-28 22:02
 */
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目（一次性查询）
        /*List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        // 精简方法 - lambda + stream API
        List<Integer> categoryTypeList = productInfoList.stream().
                map(ProductInfo::getCategoryType).
                collect(Collectors.toList());
        // 根据商品类型查询 商品类别信息
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
