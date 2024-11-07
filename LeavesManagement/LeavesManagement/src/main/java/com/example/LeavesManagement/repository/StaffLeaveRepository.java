package com.example.LeavesManagement.repository;

import com.example.LeavesManagement.model.StaffLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffLeaveRepository extends JpaRepository<StaffLeave, Long> {
    List<StaffLeave> findByStaffMemberId(Long staffMemberId);
}
