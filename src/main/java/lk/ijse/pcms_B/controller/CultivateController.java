package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cultivates")
public class CultivateController {

    @GetMapping(value = "/{cultivateID}")
    public ResponseEntity<Void> getCultivate(@PathVariable("cultivateID") String ID) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Void> getAllCultivates() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveCultivate() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateCultivate() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCultivate() {
        return null;
    }
}
