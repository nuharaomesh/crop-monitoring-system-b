package lk.ijse.pcms_B.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pcms_B.customStatusCode.SelectedFieldErrorCode;
import lk.ijse.pcms_B.dao.FieldDAO;
import lk.ijse.pcms_B.dto.FieldStatus;
import lk.ijse.pcms_B.dto.impl.FieldDTO;
import lk.ijse.pcms_B.entity.impl.Field;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.FieldNotFoundException;
import lk.ijse.pcms_B.service.FieldService;
import lk.ijse.pcms_B.util.AppUtil;
import lk.ijse.pcms_B.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldDAO fieldDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public FieldStatus getField(String fieldCode) {
        if (fieldDAO.existsById(fieldCode)) {
            Field selectedField = fieldDAO.getReferenceById(fieldCode);
            return mapping.toFieldDTO(selectedField);
        } else {
            return new SelectedFieldErrorCode(2, "Selected Field not found!");
        }
    }

    @Override
    public List<FieldDTO> getAllFields() {
        return mapping.toFieldDTOList(fieldDAO.findAll());
    }

    @Override
    public void saveField(FieldDTO dto) {
        dto.setFieldCode(AppUtil.genFieldCode());
        Field savedField =
                fieldDAO.save(mapping.toFieldEntity(dto));
        if (savedField == null) throw new DataPersistException("Field Not Saved!");
    }

    @Override
    public void updateField(String fieldCode, FieldDTO dto) {
        Optional<Field> tmpField = fieldDAO.findById(fieldCode);
        if (!tmpField.isPresent()) {
            throw new FieldNotFoundException("Field Not Found!");
        } else {
            tmpField.get().setFieldName(dto.getFieldName());
            tmpField.get().setFieldLocation(dto.getFieldLocation());
            tmpField.get().setFieldAddress(dto.getFieldAddress());
            tmpField.get().setFieldSize(dto.getFieldSize());
            tmpField.get().setImg1(dto.getImg1());
            tmpField.get().setImg2(dto.getImg2());
        }
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<Field> tmpField = fieldDAO.findById(fieldCode);
        if (!tmpField.isPresent()) {
            throw new FieldNotFoundException("Field Not Found!");
        } else {
            fieldDAO.deleteById(fieldCode);
        }
    }
}
