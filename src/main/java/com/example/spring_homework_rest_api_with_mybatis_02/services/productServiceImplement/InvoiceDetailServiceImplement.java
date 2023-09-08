package com.example.spring_homework_rest_api_with_mybatis_02.services.productServiceImplement;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;
import com.example.spring_homework_rest_api_with_mybatis_02.repository.InvoiceDetailRepository;
import com.example.spring_homework_rest_api_with_mybatis_02.services.InvoiceDetailService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImplement implements InvoiceDetailService {

private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailServiceImplement(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }


    @Override
    public Invoice getInvoiceId(Integer bookId) {
        return null;
    }
}
