package com.example.spring_homework_rest_api_with_mybatis_02.services.productServiceImplement;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Products;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.repository.ProductRepository;
import com.example.spring_homework_rest_api_with_mybatis_02.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Products getProductById(Integer productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public boolean deleteProductById(Integer productId) {
        return productRepository.deleteProductById(productId);
    }

    @Override
    public Integer addProduct(ProductRequest productRequest) {

        Integer productId = productRepository.saveProduct(productRequest);
        return productId;
    }

    @Override
    public Integer updateProduct(ProductRequest productRequest, Integer productId) {
        Integer productIdUpdate = productRepository.updateProducts(productRequest, productId);
        return productIdUpdate;
    }
}
