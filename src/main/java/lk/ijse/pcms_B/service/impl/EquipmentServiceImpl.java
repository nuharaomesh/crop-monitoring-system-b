package lk.ijse.pcms_B.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pcms_B.customStatusCode.SelectedEquipmentErrorCode;
import lk.ijse.pcms_B.dao.EquipmentDAO;
import lk.ijse.pcms_B.dto.EquipmentStatus;
import lk.ijse.pcms_B.dto.impl.EquipmentDTO;
import lk.ijse.pcms_B.entity.impl.Equipment;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.EquipmentNotFoundException;
import lk.ijse.pcms_B.service.EquipmentService;
import lk.ijse.pcms_B.util.AppUtil;
import lk.ijse.pcms_B.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentDAO equipmentDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public EquipmentStatus getEquipment(String equipmentID) {
        if (equipmentDAO.existsById(equipmentID)) {
            Equipment selectedEquipment = equipmentDAO.getReferenceById(equipmentID);
            return mapping.toEquipmentDTO(selectedEquipment);
        } else {
            return new SelectedEquipmentErrorCode(2, "Selected Equipment not found!");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return mapping.toEquipmentDTOList(equipmentDAO.findAll());
    }

    @Override
    public void saveEquipment(EquipmentDTO dto) {
        dto.setEquipmentId(AppUtil.genEquipmentID());
        Equipment savedEquipment =
                equipmentDAO.save(mapping.toEquipmentEntity(dto));
        if (savedEquipment == null) throw new DataPersistException("Equipment Not saved!");
    }

    @Override
    public void updateEquipment(String equipmentID, EquipmentDTO dto) {
        Optional<Equipment> tmpEquipment = equipmentDAO.findById(equipmentID);
        if (!tmpEquipment.isPresent()) {
            throw new EquipmentNotFoundException("Equipment Not Found!");
        } else {
            tmpEquipment.get().setName(dto.getName());
            tmpEquipment.get().setType(dto.getType());
            tmpEquipment.get().setStatus(dto.getStatus());
            tmpEquipment.get().setCount(dto.getCount());
        }
    }

    @Override
    public void deleteEquipment(String equipmentID) {
        Optional<Equipment> tmpEquipment = equipmentDAO.findById(equipmentID);
        if (!tmpEquipment.isPresent()) {
            throw new EquipmentNotFoundException("Equipment Not Found!");
        } else {
            equipmentDAO.deleteById(equipmentID);
        }
    }
}
