package com.example.TableManagement.service;

import com.example.TableManagement.model.ProductTable;
import com.example.TableManagement.repository.ProductTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTableService {

    private final ProductTableRepository productTableRepository;

    @Autowired
    public ProductTableService(ProductTableRepository productTableRepository) {
        this.productTableRepository = productTableRepository;
    }

    public ProductTable addProduct(ProductTable productTable){
        return productTableRepository.save(productTable);
    }
}
