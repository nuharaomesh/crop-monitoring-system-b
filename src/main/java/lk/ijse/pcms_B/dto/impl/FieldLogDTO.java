package lk.ijse.pcms_B.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldLogDTO {
    private String fieldID;
    private String logID;
    private Date date;
    private String observationDetail;
}
