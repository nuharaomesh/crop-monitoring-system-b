package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fields")
public class FieldController {

    @GetMapping
    public RequestEntity<Void> getField() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllFields() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveField() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateField() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteField() {
        return null;
    }
}
