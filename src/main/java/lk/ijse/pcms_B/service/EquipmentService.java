package lk.ijse.pcms_B.service;

import lk.ijse.pcms_B.dto.EquipmentStatus;
import lk.ijse.pcms_B.dto.impl.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    EquipmentStatus getEquipment(String equipmentID);
    List<EquipmentDTO> getAllEquipment();
    void saveEquipment(EquipmentDTO dto);
    void updateEquipment(String equipmentID, EquipmentDTO dto);
    void deleteEquipment(String equipmentID);
}
