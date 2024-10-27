package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {

    @GetMapping
    public RequestEntity<Void> getStaff() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllStaffs() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveStaff() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateStaff() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteStaff() {
        return null;
    }
}
