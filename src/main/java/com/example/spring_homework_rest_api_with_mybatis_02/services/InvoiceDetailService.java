package com.example.spring_homework_rest_api_with_mybatis_02.services;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;

public interface InvoiceDetailService {

    Invoice getInvoiceId (Integer bookId);
}
