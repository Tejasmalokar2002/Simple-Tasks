package com.example.TableManagement.controller;

import com.example.TableManagement.model.StoreTable;
import com.example.TableManagement.service.StoreTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class StoreTableController {

    private final StoreTableService service;

    public StoreTableController(StoreTableService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<StoreTable> addStore(@RequestBody StoreTable storeTable){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addStore(storeTable));
    }
}
