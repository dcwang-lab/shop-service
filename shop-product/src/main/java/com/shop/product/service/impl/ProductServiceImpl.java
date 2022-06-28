package com.shop.product.service.impl;

import com.shop.product.entity.Product;
import com.shop.product.mapper.ProductMapper;
import com.shop.product.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dcWang
 * @Date: 2022/5/19 18:45
 * @Description: 商品service实现
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> listProducts(Product queryParam) {
        return productMapper.listProducts(queryParam);
    }

    @Override
    public Product getProduct(Long id) {
        return productMapper.getProduct(id);
    }

    @Override
    @Transactional
    public void update(Product param) {
        productMapper.update(param);
    }
}
