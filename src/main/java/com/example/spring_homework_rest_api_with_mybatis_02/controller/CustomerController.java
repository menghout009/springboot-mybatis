package com.example.spring_homework_rest_api_with_mybatis_02.controller;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Customer;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.CustomerRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.model.response.CustomerResponse;
import com.example.spring_homework_rest_api_with_mybatis_02.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all customer")
    public ResponseEntity<CustomerResponse<List<Customer>>> getAllCustomer() {
        CustomerResponse<List<Customer>> response = CustomerResponse.<List<Customer>>builder()
                .message("Get data from customer successfully")
                .payload(customerService.getAllCustomer())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by id")
    public ResponseEntity<CustomerResponse<Customer>> getCustomerById(@PathVariable("id") Integer customerId) {
        CustomerResponse<Customer> response;
        if (customerService.getCustomerById(customerId) != null) {
            response = CustomerResponse.<Customer>builder()
                    .message("Get customer by id successfully")
                    .payload(customerService.getCustomerById(customerId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        } else {
            response = CustomerResponse.<Customer>builder()
                    .message("Get customer by id Not found")
                    .payload(customerService.getCustomerById(customerId))
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer by id")
    public ResponseEntity<CustomerResponse<String>> deleteCustomerById(@PathVariable("id") Integer customerId) {
        CustomerResponse<String> response;
        if (customerService.deleteCustomerById(customerId) == true) {
            response = CustomerResponse.<String>builder()
                    .message("Deleted data from customer successfully")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        } else {
            response = CustomerResponse.<String>builder()
                    .message("Deleted Product By Id NOT FOUND ! ")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping
    @Operation(summary = "Add data customer")
    public ResponseEntity<CustomerResponse<Customer>> addNewCustomer (@RequestBody CustomerRequest customerRequest){
        Integer storeCustomerId = customerService.addNewCustomer(customerRequest);
        if (storeCustomerId   !=null){
            CustomerResponse<Customer> response = CustomerResponse.<Customer>builder()
                    .message("Add customer data successfully")
                    .payload(customerService.getCustomerById(storeCustomerId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer by id")
    public ResponseEntity<CustomerResponse<Customer>> updateCustomerById(
             @RequestBody CustomerRequest customerRequest,@ PathVariable("id") Integer customerId){
        CustomerResponse<Customer> response = null;
        Integer idCustomerUpdate = customerService.updateCustomer(customerRequest , customerId);
        if (idCustomerUpdate !=null){
            response = CustomerResponse.<Customer>builder()
                    .message("Update customer by id successfully")
                    .payload(customerService.getCustomerById(idCustomerUpdate))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();

        }
        return ResponseEntity.ok(response);
    }
}
