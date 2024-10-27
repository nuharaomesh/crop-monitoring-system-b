package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.LogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDTO implements LogStatus {
    private String logCode;
    private Date date;
    private String details;
    private String observedImg;
}
