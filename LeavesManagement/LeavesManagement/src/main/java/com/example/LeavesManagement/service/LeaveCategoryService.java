package com.example.LeavesManagement.service;

import com.example.LeavesManagement.model.LeaveCategory;
import com.example.LeavesManagement.repository.LeaveCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveCategoryService {

    private final LeaveCategoryRepository leaveCategoryRepository;

    public LeaveCategoryService(LeaveCategoryRepository leaveCategoryRepository) {
        this.leaveCategoryRepository = leaveCategoryRepository;
    }

    public LeaveCategory addLeaveCategory(LeaveCategory leaveCategory) {
        return leaveCategoryRepository.save(leaveCategory);
    }
}
