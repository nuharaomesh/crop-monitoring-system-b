package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @GetMapping
    public RequestEntity<Void> getVehicle() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllVehicles() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveVehicle() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateVehicle() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteVehicle() {
        return null;
    }
}
