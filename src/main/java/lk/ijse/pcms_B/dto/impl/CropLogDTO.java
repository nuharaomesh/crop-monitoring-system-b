package lk.ijse.pcms_B.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropLogDTO {
    private String cropID;
    private String logID;
    private Date date;
    private Date note;
}
