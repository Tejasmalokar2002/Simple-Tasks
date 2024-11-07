package com.example.LeavesManagement.controller;

import com.example.LeavesManagement.model.StaffMember;
import com.example.LeavesManagement.service.StaffMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staffMember")
public class StaffMemberController {

    private final StaffMemberService staffMemberService;


    public StaffMemberController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    @PostMapping("/post")
    public ResponseEntity<StaffMember> addStaffMember(@RequestBody StaffMember staffMember) {
        return ResponseEntity.status(HttpStatus.CREATED).body(staffMemberService.addStaffMember(staffMember));
    }
}
