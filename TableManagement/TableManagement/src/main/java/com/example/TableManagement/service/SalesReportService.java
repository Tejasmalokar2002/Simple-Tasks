package com.example.TableManagement.service;

import com.example.TableManagement.model.ProductTable;
import com.example.TableManagement.model.SaleTable;
import com.example.TableManagement.model.StoreTable;
import com.example.TableManagement.repository.ProductTableRepository;
import com.example.TableManagement.repository.SaleTableRepository;
import com.example.TableManagement.repository.StoreTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesReportService {

    @Autowired
    private SaleTableRepository saleTableRepository;

    @Autowired
    private ProductTableRepository productTableRepository;

    @Autowired
    private StoreTableRepository storeTableRepository;

    public List<String> generateSalesReportForStore(String storeName) {
        StoreTable store = storeTableRepository.findByName(storeName);
        if (store == null) {
            throw new IllegalArgumentException("Store not found with name: " + storeName);
        }
        List<SaleTable> sales = saleTableRepository.findByStoreTable(store);

        if (sales.isEmpty()) {
            return List.of("No sales found for store: " + storeName);
        }
        return sales.stream().map(sale -> {
            // Get product details
            ProductTable product = sale.getProductTable();
            Long salesQuantity = sale.getSalesQuantity();
            Long mrp = product.getMrp();
            Long totalAmount = salesQuantity * mrp;

            return String.format("Product Name: %s Sales Quantity: %d MRP: %d Total Amount: %d ",
                    product.getName(), salesQuantity, mrp, totalAmount);
        }).collect(Collectors.toList());
    }

}
