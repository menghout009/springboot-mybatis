package com.example.spring_homework_rest_api_with_mybatis_02.repository;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Customer;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.CustomerRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerRepository {


    @Select("SELECT * FROM customers")
    List<Customer> findAllCustomer();

    @Select("SELECT * FROM customers WHERE id =#{customerId}")
    Customer getCustomerById (Integer customerId);

    @Delete("DELETE FROM customers WHERE id = #{id}")
    boolean deleteCustomerById(Integer customerId);

    @Select("INSERT INTO customers (customer_name, customer_phone, customer_address) VALUES ( #{request.customer_name}, #{request.customer_phone},  #{request.customer_address})"+
            "RETURNING id")
    Integer saveDataCustomer(@Param("request")CustomerRequest customerRequest);

    @Select("UPDATE customers "+
            "SET customer_name = #{request.customer_name},"+
            "customer_phone = #{request.customer_phone},"+
            "customer_address = #{request.customer_address}"+
            "WHERE id = #{customerId}"+
            "RETURNING id")

    Integer updateCustomer(@Param("request") CustomerRequest customerRequest, Integer customerId);



}
