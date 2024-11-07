package com.example.LeavesManagement.repository;

import com.example.LeavesManagement.model.LeaveCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveCategoryRepository extends JpaRepository<LeaveCategory, Long> {
}
