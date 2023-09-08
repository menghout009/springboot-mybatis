package com.example.spring_homework_rest_api_with_mybatis_02.services;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Products;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    List<Products> getAllProducts();

    Products getProductById(Integer productId);

    boolean deleteProductById(Integer productId);

    Integer addProduct(ProductRequest productRequest);

    Integer updateProduct(ProductRequest productRequest, Integer productId);


}
