package com.example.LeavesManagement.service;

import com.example.LeavesManagement.dto.LeaveDetail;
import com.example.LeavesManagement.dto.LeaveSummaryDTO;
import com.example.LeavesManagement.dto.LeaveCategorySummary;
import com.example.LeavesManagement.model.LeaveCategory;
import com.example.LeavesManagement.model.StaffLeave;
import com.example.LeavesManagement.model.StaffMember;
import com.example.LeavesManagement.repository.LeaveCategoryRepository;
import com.example.LeavesManagement.repository.StaffLeaveRepository;
import com.example.LeavesManagement.repository.StaffMemberRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StaffLeaveService {

    private final StaffLeaveRepository staffLeaveRepository;
    private final StaffMemberRepository staffMemberRepository;
    private final LeaveCategoryRepository leaveCategoryRepository;

    public StaffLeaveService(StaffLeaveRepository staffLeaveRepository,
                             StaffMemberRepository staffMemberRepository,
                             LeaveCategoryRepository leaveCategoryRepository) {
        this.staffLeaveRepository = staffLeaveRepository;
        this.staffMemberRepository = staffMemberRepository;
        this.leaveCategoryRepository = leaveCategoryRepository;
    }

    public StaffLeave addStaffLeave(StaffLeave staffLeave) {
        Optional<StaffMember> staffMember = staffMemberRepository.findById(staffLeave.getStaffMember().getId());
        staffMember.ifPresent(staffLeave::setStaffMember);
        Optional<LeaveCategory> leaveCategory = leaveCategoryRepository.findById(staffLeave.getLeaveCategory().getCategoryId());
        leaveCategory.ifPresent(staffLeave::setLeaveCategory);
        return staffLeaveRepository.save(staffLeave);
    }

    public LeaveSummaryDTO getLeaveSummaryForStaffMember(Long staffMemberId) {
        Optional<StaffMember> staffMember = staffMemberRepository.findById(staffMemberId);
        if (!staffMember.isPresent()) {
            return new LeaveSummaryDTO();
        }
        // Retrieve all leaves taken by this staff member
        List<StaffLeave> staffLeaves = staffLeaveRepository.findByStaffMemberId(staffMemberId);

        Map<String, Map<String, Long>> leaveCountsByCategoryAndDate = staffLeaves.stream()
                .collect(Collectors.groupingBy(
                        staffLeave -> staffLeave.getLeaveCategory().getCategoryName(),
                        Collectors.groupingBy(
                                staffLeave -> staffLeave.getDate().toString(),
                                Collectors.counting()
                        )
                ));


        int totalLeaves = 20;

        int totalLeavesTaken = staffLeaves.size();
        int remainingLeaves = totalLeaves - totalLeavesTaken;
        int excessLeaves = remainingLeaves < 0 ? Math.abs(remainingLeaves) : 0;


        LeaveSummaryDTO leaveSummaryDTO = new LeaveSummaryDTO();
        leaveSummaryDTO.setStaffId(String.valueOf(staffMember.get().getId()));
        leaveSummaryDTO.setStaffName(staffMember.get().getName());
        leaveSummaryDTO.setTotalLeaves(totalLeaves);
        leaveSummaryDTO.setLeavesTaken(totalLeavesTaken);
        leaveSummaryDTO.setRemainingLeaves(Math.max(remainingLeaves, 0));
        leaveSummaryDTO.setExcessLeaves(excessLeaves);

        List<LeaveSummaryDTO.LeaveDetail> leaveDetails = new ArrayList<>();

        leaveCountsByCategoryAndDate.forEach((categoryName, dateMap) -> {
            dateMap.forEach((date, count) -> {
                LeaveSummaryDTO.LeaveDetail detail = new LeaveSummaryDTO.LeaveDetail();
                detail.setCategoryName(categoryName);
                detail.setLeaveDate(date);
                detail.setLeavesTaken(count.intValue());
                leaveDetails.add(detail);
            });
        });

        leaveSummaryDTO.setLeaveDetails(leaveDetails);

        return leaveSummaryDTO;
    }
}
