package com.example.spring_homework_rest_api_with_mybatis_02.controller;
import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Invoice;
import com.example.spring_homework_rest_api_with_mybatis_02.model.response.InvoiceResponse;
import com.example.spring_homework_rest_api_with_mybatis_02.services.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all invoices")
    public ResponseEntity <InvoiceResponse<List<Invoice>>> getAllInvoice(){

        InvoiceResponse<List<Invoice>> response = null;
         if (invoiceService.getAllInvoice() !=null){
             response = InvoiceResponse.<List<Invoice>>builder()
                     .message("Get all invoices successfully")
                     .httpStatus(HttpStatus.OK)
                     .payload(invoiceService.getAllInvoice())
                     .timestamp(new Timestamp(System.currentTimeMillis()))
                     .build();
         }
         return ResponseEntity.ok(response);
    }
}
