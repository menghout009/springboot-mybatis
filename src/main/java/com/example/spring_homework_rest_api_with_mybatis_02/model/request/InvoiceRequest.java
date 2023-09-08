package com.example.spring_homework_rest_api_with_mybatis_02.model.request;


import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest{

    private Timestamp timestamp;
    private Customer customer;
}
