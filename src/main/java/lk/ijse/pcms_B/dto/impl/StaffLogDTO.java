package lk.ijse.pcms_B.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffLogDTO {
    private String staffID;
    private String logID;
    private Date date;
    public String observationRole;
}
