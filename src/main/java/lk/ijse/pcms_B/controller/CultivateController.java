package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cultivates")
public class CultivateController {

    @GetMapping
    public RequestEntity<Void> getCultivate() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllCultivates() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveCultivate() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateCultivate() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteCultivate() {
        return null;
    }
}
