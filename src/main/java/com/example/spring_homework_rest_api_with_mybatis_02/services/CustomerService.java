package com.example.spring_homework_rest_api_with_mybatis_02.services;
import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Customer;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.CustomerRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer ();

    Customer getCustomerById (Integer customerId);

     boolean deleteCustomerById(Integer customerId);

     Integer addNewCustomer(CustomerRequest customerRequest );

    Integer updateCustomer(CustomerRequest customerRequest, Integer CustomerId);

}
