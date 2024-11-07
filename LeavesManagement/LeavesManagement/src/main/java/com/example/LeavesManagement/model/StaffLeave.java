package com.example.LeavesManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "STAFF_LEAVE") // Explicit table name for clarity
public class StaffLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STAFF_MEMBER_ID", referencedColumnName = "id") // Reference to StaffMember entity
    private StaffMember staffMember;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEAVE_CATEGORY_ID", referencedColumnName = "CATEGORY_ID") // Reference to LeaveCategory entity
    private LeaveCategory leaveCategory;

    @Column(name = "LEAVE_DATE")
    private Date date;
}
