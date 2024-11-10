package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lk.ijse.pcms_B.enums.Gender;
import lk.ijse.pcms_B.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Staff")
public class Staff implements SuperEntity {
    @Id
    private String staffID;
    private String firstName;
    private String lastName;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "staff")
    private List<FieldAssignment> fieldAssignments;
    @OneToMany(mappedBy = "staff")
    private List<StaffAssignment> staffAssignments;
    @OneToMany(mappedBy = "staff")
    private List<StaffLog> staffLogs;
    @ManyToOne
    @JoinColumn(name = "equipmentID")
    private Equipment equipment;
}
