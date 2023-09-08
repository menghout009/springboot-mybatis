package com.example.spring_homework_rest_api_with_mybatis_02.services.productServiceImplement;

import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;
import com.example.spring_homework_rest_api_with_mybatis_02.repository.InvoiceRepository;
import com.example.spring_homework_rest_api_with_mybatis_02.services.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImplement implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImplement(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAllInvoice() {
         return invoiceRepository.findAllInvoices();
    }

}
