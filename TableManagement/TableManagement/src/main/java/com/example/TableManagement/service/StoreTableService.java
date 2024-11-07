package com.example.TableManagement.service;

import com.example.TableManagement.model.StoreTable;
import com.example.TableManagement.repository.StoreTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreTableService {

    private final StoreTableRepository storeTableRepository;

    @Autowired
    public StoreTableService(StoreTableRepository storeTableRepository) {
        this.storeTableRepository = storeTableRepository;
    }

    public StoreTable addStore(StoreTable storeTable){
        return storeTableRepository.save(storeTable);
    }
}
