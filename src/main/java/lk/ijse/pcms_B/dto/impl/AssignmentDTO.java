package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.AssignmentStatus;
import lk.ijse.pcms_B.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssignmentDTO implements AssignmentStatus {
    private String staffID;
    private String vehicleID;
    private Date assignmentDate;
    private Availability status;
}
