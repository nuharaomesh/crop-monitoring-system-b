package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {

    @GetMapping
    public RequestEntity<Void> getCrop() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllCrops() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveCrop() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateCrop() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteCrop() {
        return null;
    }
}
