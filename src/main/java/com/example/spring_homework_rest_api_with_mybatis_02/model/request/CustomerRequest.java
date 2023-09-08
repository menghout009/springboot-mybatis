package com.example.spring_homework_rest_api_with_mybatis_02.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    private String customer_name;
    private String customer_address;
    private String customer_phone;


}
