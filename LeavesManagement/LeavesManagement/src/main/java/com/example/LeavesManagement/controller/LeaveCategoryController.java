package com.example.LeavesManagement.controller;

import com.example.LeavesManagement.model.LeaveCategory;
import com.example.LeavesManagement.service.LeaveCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leaveCategory")
public class LeaveCategoryController {

    private final LeaveCategoryService leaveCategoryService;

    public LeaveCategoryController(LeaveCategoryService leaveCategoryService) {
        this.leaveCategoryService = leaveCategoryService;
    }

    @PostMapping("/post")
    public ResponseEntity<LeaveCategory> addLeaveCategory(@RequestBody LeaveCategory leaveCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leaveCategoryService.addLeaveCategory(leaveCategory));
    }
}
