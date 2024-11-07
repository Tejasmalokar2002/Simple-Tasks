package com.example.TableManagement.repository;

import com.example.TableManagement.model.SaleTable;
import com.example.TableManagement.model.StoreTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleTableRepository extends JpaRepository<SaleTable, Long> {
    List<SaleTable> findByStoreTable(StoreTable storeTable);
}
