package lk.ijse.pcms_B.service;

import lk.ijse.pcms_B.dto.CropStatus;
import lk.ijse.pcms_B.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    CropStatus getCrop(String cropCode);
    List<CropDTO> getAllCrops();
    void saveCrop(CropDTO dto);
    void updateCrop(String cropCode, CropDTO dto);
    void deleteCrop(String cropCode);
}
