package com.example.TableManagement.controller;

import com.example.TableManagement.model.ProductTable;
import com.example.TableManagement.service.ProductTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductTableController {

    private final ProductTableService productTableService;

    public ProductTableController(ProductTableService productTableService) {
        this.productTableService = productTableService;
    }

    @PostMapping("/post")
    public ResponseEntity<ProductTable> addProduct(@RequestBody ProductTable productTable){
        return ResponseEntity.status(HttpStatus.CREATED).body(productTableService.addProduct(productTable));
    }
}
