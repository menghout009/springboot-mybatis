package com.example.spring_homework_rest_api_with_mybatis_02.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {

    private Integer id;
    private String product_name;
    private double product_prices;


}
