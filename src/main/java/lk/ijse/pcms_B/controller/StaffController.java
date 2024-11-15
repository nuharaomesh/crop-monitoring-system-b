package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedStaffErrorCode;
import lk.ijse.pcms_B.dto.StaffStatus;
import lk.ijse.pcms_B.dto.impl.StaffDTO;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.StaffNotFoundException;
import lk.ijse.pcms_B.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/{staffID}")
    public StaffStatus getStaff(@PathVariable("staffID") String staffID) {
        if (staffID.isEmpty() || staffID == null) {
            return new SelectedStaffErrorCode(1, "Staff ID is Not Valid!");
        }
        return staffService.getStaff(staffID);
    }

    @GetMapping
    public List<StaffDTO> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @PostMapping
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDTO dto) {
        try {
            staffService.saveStaff(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{staffID}")
    public ResponseEntity<Void> updateStaff(@PathVariable("staffID") String staffID, @RequestBody StaffDTO dto) {
        try {
            staffService.updateStaff(staffID, dto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{staffID}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("staffID") String staffID) {
        try {
            staffService.deleteStaff(staffID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
