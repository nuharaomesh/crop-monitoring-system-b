package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
    private String cropCode;
    private String cropName;
    private String cropScientificName;
    private String cropImg;
    private String category;
    private String cropSeason;
    private String cropTimeRange;
}
