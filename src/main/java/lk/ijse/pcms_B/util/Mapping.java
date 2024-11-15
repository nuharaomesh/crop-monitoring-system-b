package lk.ijse.pcms_B.util;

import lk.ijse.pcms_B.dto.impl.EquipmentDTO;
import lk.ijse.pcms_B.dto.impl.FieldDTO;
import lk.ijse.pcms_B.entity.impl.Equipment;
import lk.ijse.pcms_B.entity.impl.Field;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public Field toFieldEntity(FieldDTO dto) {
        return modelMapper.map(dto, Field.class);
    }

    public FieldDTO toFieldDTO(Field entity) {
        return modelMapper.map(entity, FieldDTO.class);
    }

    public List<FieldDTO> toFieldDTOList(List<Field> fieldList) {
        return modelMapper.map(fieldList, new TypeToken<List<FieldDTO>>(){}.getType());
    }

    public Equipment toEquipmentEntity(EquipmentDTO dto) {
        return modelMapper.map(dto, Equipment.class);
    }

    public EquipmentDTO toEquipmentDTO(Equipment entity) {
        return modelMapper.map(entity, EquipmentDTO.class);
    }

    public List<EquipmentDTO> toEquipmentDTOList(List<Equipment> equipmentList) {
        return modelMapper.map(equipmentList, new TypeToken<List<EquipmentDTO>>(){}.getType());
    }
}
