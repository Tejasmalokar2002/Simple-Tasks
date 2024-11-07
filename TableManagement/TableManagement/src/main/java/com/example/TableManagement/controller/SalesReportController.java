package com.example.TableManagement.controller;

import com.example.TableManagement.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping("/{storeName}")
    public List<String> getSalesReportForStore(@PathVariable String storeName) {
        return salesReportService.generateSalesReportForStore(storeName);
    }
}
