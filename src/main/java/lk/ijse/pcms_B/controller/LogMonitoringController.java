package lk.ijse.pcms_B.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/logs")
public class LogMonitoringController {

    @GetMapping(value = "logCode")
    public ResponseEntity<Void> getLog(@PathVariable("logCode") String logCode) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Void> getAllLogs() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> saveLog() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateLog() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLog() {
        return null;
    }
}
