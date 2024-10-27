package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.StaffFieldStatus;
import lk.ijse.pcms_B.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffFieldDTO implements StaffFieldStatus {
    private String staffID;
    private String fieldID;
    private Date date;
    private Availability status;
}
