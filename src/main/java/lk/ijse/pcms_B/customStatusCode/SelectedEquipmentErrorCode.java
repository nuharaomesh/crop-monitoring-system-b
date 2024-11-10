package lk.ijse.pcms_B.customStatusCode;

import lk.ijse.pcms_B.dto.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedEquipmentErrorCode implements EquipmentStatus {
    private int statusCode;
    private String statusMessage;
}
