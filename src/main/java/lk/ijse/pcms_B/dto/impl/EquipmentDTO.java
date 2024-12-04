package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.EquipmentStatus;
import lk.ijse.pcms_B.enums.Availability;
import lk.ijse.pcms_B.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements EquipmentStatus {
    private String equipmentId;
    private String name;
    private EquipmentType type;
    private Availability status;
    private int count;
    private String staffID;
}
