package com.example.TableManagement.repository;

import com.example.TableManagement.model.StoreTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreTableRepository extends JpaRepository<StoreTable, Long> {
    StoreTable findByName(String name);
}
