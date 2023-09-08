package com.example.spring_homework_rest_api_with_mybatis_02.repository;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvoiceDetailRepository {

    @Select( "SELECT pt.id pt.product_name, pt.product_prices FROM products pt INNER JOIN invoice_details ids " +
            "ON pt.product_id = ids.product_id" +
            "WHERE ids.invoice_id = #{invoiceId}" )
    List<Products> getInvoiceById(Integer invoiceId);

}
