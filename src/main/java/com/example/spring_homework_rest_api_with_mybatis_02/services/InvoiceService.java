package com.example.spring_homework_rest_api_with_mybatis_02.services;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoice();
}
