package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.VehicleStaffStatus;
import lk.ijse.pcms_B.enums.VehicleStat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleStaff implements VehicleStaffStatus {
    private String staffID;
    private String vehicleID;
    private Date assignmentDate;
    private VehicleStat status;
}
