package com.example.spring_homework_rest_api_with_mybatis_02.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
    private Integer id;
    private Timestamp invoice_date;
    private Customer customer;
    private List<Products> products;

}
