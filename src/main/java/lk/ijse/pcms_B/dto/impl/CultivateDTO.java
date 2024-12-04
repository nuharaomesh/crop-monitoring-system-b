package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.CultivateStatus;
import lk.ijse.pcms_B.enums.HarvestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CultivateDTO implements CultivateStatus {
    private String cultivateID;
    private Date plantingDate;
    private Date ExpectedHarvestDate;
    private String cropName;
    private HarvestStatus status;
    private String cropID;
    private String fieldID;
}
