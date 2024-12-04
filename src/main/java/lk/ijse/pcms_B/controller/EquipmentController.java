package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedEquipmentErrorCode;
import lk.ijse.pcms_B.dto.EquipmentStatus;
import lk.ijse.pcms_B.dto.impl.EquipmentDTO;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.EquipmentNotFoundException;
import lk.ijse.pcms_B.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping(value = "/{equipmentID}")
    public EquipmentStatus getEquipment(@PathVariable("equipmentID") String ID) {
        if (ID.isEmpty() || ID == null)
            return new SelectedEquipmentErrorCode(1, "Equipment ID is Not Valid!");
        return equipmentService.getEquipment(ID);
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipments() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDTO dto) {
        try {
            equipmentService.saveEquipment(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{equipmentID}")
    public ResponseEntity<Void> updateEquipment(@PathVariable("equipmentID") String equipmentID, @RequestBody EquipmentDTO dto) {
        try {
            equipmentService.updateEquipment(equipmentID, dto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{equipmentID}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable("equipmentID") String equipmentID) {
        try {
            equipmentService.deleteEquipment(equipmentID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EquipmentNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
