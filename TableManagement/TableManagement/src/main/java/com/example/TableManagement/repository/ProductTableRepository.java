package com.example.TableManagement.repository;

import com.example.TableManagement.model.ProductTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTableRepository extends JpaRepository<ProductTable, Long> {
}
