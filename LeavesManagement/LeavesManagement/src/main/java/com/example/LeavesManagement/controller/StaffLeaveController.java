package com.example.LeavesManagement.controller;

import com.example.LeavesManagement.dto.LeaveSummaryDTO;
import com.example.LeavesManagement.model.StaffLeave;
import com.example.LeavesManagement.service.StaffLeaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staffLeave")
public class StaffLeaveController {

    private final StaffLeaveService staffLeaveService;

    public StaffLeaveController(StaffLeaveService staffLeaveService) {
        this.staffLeaveService = staffLeaveService;
    }

    @PostMapping("/post")
    public ResponseEntity<StaffLeave> addLeave(@RequestBody StaffLeave staffLeave){
        return ResponseEntity.status(HttpStatus.CREATED).body(staffLeaveService.addStaffLeave(staffLeave));
    }

    @GetMapping("/summary/{staffMemberId}")
    public ResponseEntity<LeaveSummaryDTO> getLeaveSummary(@PathVariable Long staffMemberId) {
        LeaveSummaryDTO leaveSummary = staffLeaveService.getLeaveSummaryForStaffMember(staffMemberId);
        return ResponseEntity.ok(leaveSummary);
    }
}
