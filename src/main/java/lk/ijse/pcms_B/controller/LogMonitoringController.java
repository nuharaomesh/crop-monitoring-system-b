package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/logs")
public class LogMonitoringController {

    @GetMapping
    public RequestEntity<Void> getLog() {
        return null;
    }

    @GetMapping
    public RequestEntity<Void> getAllLogs() {
        return null;
    }

    @PostMapping
    public RequestEntity<Void> saveLog() {
        return null;
    }

    @PutMapping
    public RequestEntity<Void> updateLog() {
        return null;
    }

    @DeleteMapping
    public RequestEntity<Void> deleteLog() {
        return null;
    }
}
