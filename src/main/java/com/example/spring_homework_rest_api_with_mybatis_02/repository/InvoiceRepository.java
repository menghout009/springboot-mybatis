package com.example.spring_homework_rest_api_with_mybatis_02.repository;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InvoiceRepository  {

    @Select("SELECT * FROM Invoice")
    @Result(property = "id" , column="invoice_id")
    @Result(property = "customer", column = "invoice_id",
    one = @One(select = "com.example.spring_homework_rest_api_with_mybatis_02.repository.CustomerRepository.getCustomerById" )
    )
    @Result(property = "products", column = "invoice_id",
    many = @Many(select = "com.example.spring_homework_rest_api_with_mybatis_02.repository.ProductRepository.findAllProducts")
    )
    List <Invoice>  findAllInvoices() ;

}
