package com.example.spring_homework_rest_api_with_mybatis_02.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private Double product_prices;
    private String product_name;
}
