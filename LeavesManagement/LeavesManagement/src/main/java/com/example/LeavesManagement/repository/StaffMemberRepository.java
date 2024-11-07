package com.example.LeavesManagement.repository;

import com.example.LeavesManagement.model.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffMemberRepository extends JpaRepository<StaffMember, Long> {
}
