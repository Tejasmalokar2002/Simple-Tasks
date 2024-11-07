package com.example.TableManagement.controller;

import com.example.TableManagement.model.SaleTable;
import com.example.TableManagement.service.SalesTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SalesTableController {

    private final SalesTableService salesTableService;

    public SalesTableController(SalesTableService salesTableService) {
        this.salesTableService = salesTableService;
    }

    @PostMapping("/post")
    public ResponseEntity<SaleTable> addSales(@RequestBody SaleTable saleTable){
        return ResponseEntity.status(HttpStatus.CREATED).body(salesTableService.addSales(saleTable));
    }
}
