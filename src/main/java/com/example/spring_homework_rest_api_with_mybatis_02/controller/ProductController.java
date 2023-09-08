package com.example.spring_homework_rest_api_with_mybatis_02.controller;
import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Products;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.ProductRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.model.response.ProductResponse;
import com.example.spring_homework_rest_api_with_mybatis_02.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    @Operation(summary = "To Get All products")
    public ResponseEntity<ProductResponse<List<Products>>> getAllProduct() {

        ProductResponse<List<Products>> response = ProductResponse.<List<Products>>builder()
                .message("Fetch data successfully")
                .payload(productService.getAllProducts())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product By Id")
    public ResponseEntity<ProductResponse<Products>> getProductById(@PathVariable("id") Integer productId) {
        ProductResponse<Products> response;
        if (productService.getProductById(productId) != null) {
            response = ProductResponse.<Products>builder()
                    .message("Get Product By Id Successfully")
                    .payload(productService.getProductById(productId))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .httpStatus(HttpStatus.OK)
                    .build();
            return ResponseEntity.ok(response);
        } else {
            response = ProductResponse.<Products>builder()
                    .message("Get Product Not Found")
                    .payload(productService.getProductById(productId))
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Product By Id")
    public ResponseEntity<ProductResponse<String>> deleteProductById(@PathVariable("id") Integer productId) {
        ProductResponse<String> response = null;
        if (productService.deleteProductById(productId) == true) {
            response = ProductResponse.<String>builder()
                    .message("Deleted Product By Id Successfully ")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        } else {
            response = ProductResponse.<String>builder()
                    .message("Deleted Product By Id NOT FOUND ! ")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping
    @Operation(summary = "Save Product")
    public ResponseEntity<ProductResponse<Products>> addProduct(@RequestBody ProductRequest productRequest) {
        Integer storeProductId = productService.addProduct(productRequest);
        if (storeProductId != null) {
            ProductResponse<Products> response = ProductResponse.<Products>builder()
                    .message("Post data successfully")
                    .httpStatus(HttpStatus.OK)
                    .payload(productService.getProductById(storeProductId))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updated product ")
    public ResponseEntity<ProductResponse<Products>> updateProductById(
            @RequestBody ProductRequest productRequest, @PathVariable("id") Integer productId){
        ProductResponse<Products> response = null;
        Integer idProductUpdate = productService.updateProduct(productRequest,productId);
        if (idProductUpdate !=null){
            response = ProductResponse.<Products>builder()
                    .message("Updated products successfully")
                    .payload(productService.getProductById(idProductUpdate))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(response);
    }
}
