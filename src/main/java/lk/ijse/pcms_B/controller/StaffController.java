package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedStaffErrorCode;
import lk.ijse.pcms_B.dto.StaffStatus;
import lk.ijse.pcms_B.dto.impl.StaffDTO;
import lk.ijse.pcms_B.enums.Gender;
import lk.ijse.pcms_B.enums.Role;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.StaffNotFoundException;
import lk.ijse.pcms_B.service.StaffService;
import lk.ijse.pcms_B.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
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
    public ResponseEntity<Void> saveStaff(
            @RequestPart("firstname") String firstname,
            @RequestPart("lastname") String lastname,
            @RequestPart("gender") String gender,
            @RequestPart("staffImg") MultipartFile staffImg,
            @RequestPart("dob") String dob,
            @RequestPart("joinedDate") String joinedDate,
            @RequestPart("address") String address,
            @RequestPart("phnNo") String phnNo,
            @RequestPart("email") String email,
            @RequestPart("role") String role

    ) {
        try {
            byte[] bytesStaffImg = staffImg.getBytes();
            String base64StaffImg = AppUtil.imgToBase64(bytesStaffImg);

            var buildStaffDTO = new StaffDTO();

            buildStaffDTO.setFirstName(firstname);
            buildStaffDTO.setLastName(lastname);
            buildStaffDTO.setStaffImg(base64StaffImg);
            buildStaffDTO.setGender(Gender.valueOf(gender));
            System.out.println(buildStaffDTO.getGender());
//            buildStaffDTO.setDob(dob);
//            buildStaffDTO.setJoinedDate(joinedDate);
            buildStaffDTO.setAddressLine1(address);
            buildStaffDTO.setAddressLine2(address);
            buildStaffDTO.setAddressLine3(address);
            buildStaffDTO.setAddressLine4(address);
            buildStaffDTO.setAddressLine5(address);
            buildStaffDTO.setContactNo(phnNo);
            buildStaffDTO.setEmail(email);
            buildStaffDTO.setRole(Role.valueOf(role));
            staffService.saveStaff(buildStaffDTO);
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
    public ResponseEntity<Void> updateStaff(
            @PathVariable("staffID") String staffID,
            @RequestPart("firstname") String firstname,
            @RequestPart("lastname") String lastname,
            @RequestPart("gender") String gender,
            @RequestPart("staffImg") MultipartFile staffImg,
            @RequestPart("dob") String dob,
            @RequestPart("joinedDate") String joinedDate,
            @RequestPart("address") String address,
            @RequestPart("phnNo") String phnNo,
            @RequestPart("email") String email,
            @RequestPart("role") String role
    ) {
        try {
            byte[] bytesStaffImg = staffImg.getBytes();
            String base64StaffImg = AppUtil.imgToBase64(bytesStaffImg);

            var buildStaffDTO = new StaffDTO();

            buildStaffDTO.setFirstName(firstname);
            buildStaffDTO.setLastName(lastname);
            buildStaffDTO.setStaffImg(base64StaffImg);
            buildStaffDTO.setGender(Gender.valueOf(gender));
            System.out.println(buildStaffDTO.getGender());

//            buildStaffDTO.setDob(dob);
//            buildStaffDTO.setJoinedDate(joinedDate);
            buildStaffDTO.setAddressLine1(address);
            buildStaffDTO.setAddressLine2(address);
            buildStaffDTO.setAddressLine3(address);
            buildStaffDTO.setAddressLine4(address);
            buildStaffDTO.setAddressLine5(address);
            buildStaffDTO.setContactNo(phnNo);
            buildStaffDTO.setEmail(email);
            buildStaffDTO.setRole(Role.valueOf(role));
            staffService.updateStaff(staffID, buildStaffDTO);
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
        System.out.println(staffID);
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
