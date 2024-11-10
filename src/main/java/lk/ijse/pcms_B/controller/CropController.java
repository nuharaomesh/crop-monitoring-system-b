package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {

    @GetMapping(value = "/{cropID}")
    public ResponseEntity<Void> getCrop(@PathVariable("cropID") String ID) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Void> getAllCrops() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveCrop() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateCrop() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCrop() {
        return null;
    }
}
