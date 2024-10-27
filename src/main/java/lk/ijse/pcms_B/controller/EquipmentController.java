package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/equipments")
public class EquipmentController {

    @GetMapping
    public RequestEntity<Void> getEquipment() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllEquipments() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveEquipment() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateEquipment() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteEquipment() {
        return null;
    }
}
