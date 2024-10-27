package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String fieldSize;
    private String img1;
    private String img2;
}
