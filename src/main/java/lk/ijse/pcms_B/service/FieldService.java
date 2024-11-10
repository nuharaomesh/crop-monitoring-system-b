package lk.ijse.pcms_B.service;

import lk.ijse.pcms_B.dto.FieldStatus;
import lk.ijse.pcms_B.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    FieldStatus getField(String fieldCode);
    List<FieldDTO> getAllFields();
    void saveField(FieldDTO dto);
    void updateField(String fieldCode, FieldDTO dto);
    void deleteField(String fieldCode);
}
