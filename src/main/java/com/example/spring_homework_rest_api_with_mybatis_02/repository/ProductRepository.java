package com.example.spring_homework_rest_api_with_mybatis_02.repository;
import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Products;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("SELECT * FROM products ")
    List<Products> findAllProducts();

    @Select("SELECT * FROM products WHERE id =  #{id}")
    Products getProductById(Integer productId);

    @Delete("DELETE FROM products WHERE id = #{id}")
    boolean deleteProductById(Integer productId);

    @Select("INSERT INTO products (product_name, product_prices) VALUES (#{request.product_name},#{request.product_prices} )"
            +"RETURNING id")
    Integer saveProduct(@Param("request") ProductRequest productRequest);

    @Select("UPDATE products "+
            "SET product_name = #{request.product_name},"+
            "product_prices = #{request.product_prices}"+
            "WHERE id = #{productId}"+
            "RETURNING id")
    Integer updateProducts(@Param("request") ProductRequest productRequest,Integer productId);

}
