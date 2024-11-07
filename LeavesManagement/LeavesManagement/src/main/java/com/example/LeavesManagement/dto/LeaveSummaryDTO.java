package com.example.LeavesManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveSummaryDTO {
    private String staffId;
    private String staffName;
    private int totalLeaves;
    private int leavesTaken;
    private int remainingLeaves;
    private int excessLeaves;
    private List<LeaveDetail> leaveDetails; // List to hold detailed leave data


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LeaveDetail {
        private String categoryName;
        private String leaveDate; // Store the leave date as a string to match the date format
        private int leavesTaken;
    }


}
