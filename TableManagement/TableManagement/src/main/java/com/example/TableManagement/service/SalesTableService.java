package com.example.TableManagement.service;

import com.example.TableManagement.model.ProductTable;
import com.example.TableManagement.model.SaleTable;
import com.example.TableManagement.model.StoreTable;
import com.example.TableManagement.repository.ProductTableRepository;
import com.example.TableManagement.repository.SaleTableRepository;
import com.example.TableManagement.repository.StoreTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesTableService {

    private final SaleTableRepository saleTableRepository;

    private final ProductTableRepository productTableRepository;

    private final StoreTableRepository storeTableRepository;
    @Autowired
    public SalesTableService(SaleTableRepository saleTableRepository, ProductTableRepository productTableRepository, StoreTableRepository storeTableRepository) {
        this.saleTableRepository = saleTableRepository;
        this.productTableRepository = productTableRepository;
        this.storeTableRepository = storeTableRepository;
    }

    public SaleTable addSales(SaleTable saleTable) {
        Optional<ProductTable> productTableOptional = productTableRepository.findById(saleTable.getProductTable().getProductId());
        productTableOptional.ifPresent(saleTable::setProductTable);

        Optional<StoreTable> storeTableOptional = storeTableRepository.findById(saleTable.getStoreTable().getStoreId());
        storeTableOptional.ifPresent(saleTable::setStoreTable);

        return saleTableRepository.save(saleTable);
    }


}
