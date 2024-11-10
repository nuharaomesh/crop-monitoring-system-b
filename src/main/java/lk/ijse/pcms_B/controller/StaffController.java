package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {

    @GetMapping(value = "/{staffID}")
    public ResponseEntity<Void> getStaff(@PathVariable("staffID") String ID) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Void> getAllStaffs() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveStaff() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateStaff() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStaff() {
        return null;
    }
}
