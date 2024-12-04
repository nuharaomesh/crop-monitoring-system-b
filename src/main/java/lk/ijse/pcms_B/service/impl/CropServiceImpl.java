package lk.ijse.pcms_B.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pcms_B.customStatusCode.SelectedCropErrorCode;
import lk.ijse.pcms_B.dao.CropDAO;
import lk.ijse.pcms_B.dto.CropStatus;
import lk.ijse.pcms_B.dto.impl.CropDTO;
import lk.ijse.pcms_B.entity.impl.Crop;
import lk.ijse.pcms_B.exception.CropNotFoundException;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.service.CropService;
import lk.ijse.pcms_B.util.AppUtil;
import lk.ijse.pcms_B.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceImpl implements CropService {

    @Autowired
    private CropDAO cropDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public CropStatus getCrop(String cropCode) {
        if (cropDAO.existsById(cropCode)) {
            Crop selectedCrop = cropDAO.getReferenceById(cropCode);
            return mapping.toCropDTO(selectedCrop);
        } else {
            return new SelectedCropErrorCode(2, "Selected Crop not found!");
        }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return mapping.toCropDTOList(cropDAO.findAll());
    }

    @Override
    public void saveCrop(CropDTO dto) {
        dto.setCropCode(AppUtil.genCropCode());
        Crop savedCrop =
                cropDAO.save(mapping.toCropEntity(dto));
        if (savedCrop == null) throw new DataPersistException("Crop Not Saved!");
    }

    @Override
    public void updateCrop(String cropCode, CropDTO dto) {
        Optional<Crop> tmpCrop = cropDAO.findById(cropCode);
        System.out.println("crop code" + cropCode);

        if (!tmpCrop.isPresent()) {
            throw new CropNotFoundException("Crop Not Found!");
        } else {
            tmpCrop.get().setCropName(dto.getCropName());
            tmpCrop.get().setCropScientificName(dto.getCropScientificName());
            tmpCrop.get().setCropImg(dto.getCropImg());
            tmpCrop.get().setCategory(dto.getCategory());
            tmpCrop.get().setCropSeason(dto.getCropSeason());
            tmpCrop.get().setCropTimeRange(dto.getCropTimeRange());
        }
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<Crop> tmpCrop = cropDAO.findById(cropCode);
        if (!tmpCrop.isPresent()) {
            throw new CropNotFoundException("Field Not Found!");
        } else {
            cropDAO.deleteById(cropCode);
        }
    }
}
