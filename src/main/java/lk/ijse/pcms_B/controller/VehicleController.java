package lk.ijse.pcms_B.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @GetMapping(value = "/{vehicleCode}")
    public ResponseEntity<Void> getVehicle(@PathVariable("vehicleCode") String vehicleCode) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Void> getAllVehicles() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveVehicle() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateVehicle() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVehicle() {
        return null;
    }
}
