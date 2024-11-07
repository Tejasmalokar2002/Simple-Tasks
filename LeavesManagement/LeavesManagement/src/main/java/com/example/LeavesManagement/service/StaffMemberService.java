package com.example.LeavesManagement.service;

import com.example.LeavesManagement.model.StaffMember;
import com.example.LeavesManagement.repository.StaffMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffMemberService {

    private final StaffMemberRepository staffMemberRepository;

    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    public StaffMember addStaffMember(StaffMember staffMember) {
        return staffMemberRepository.save(staffMember);
    }
}
