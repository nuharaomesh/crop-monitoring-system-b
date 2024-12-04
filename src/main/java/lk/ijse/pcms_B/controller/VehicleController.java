package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedVehicleErrorCode;
import lk.ijse.pcms_B.dto.VehicleStatus;
import lk.ijse.pcms_B.dto.impl.VehicleDTO;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.VehicleNotFoundException;
import lk.ijse.pcms_B.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/{vehicleCode}")
    public VehicleStatus getVehicle(@PathVariable("vehicleCode") String vehicleCode) {
        if (vehicleCode.isEmpty() || vehicleCode == null) {
            return new SelectedVehicleErrorCode(1, "Vehicle CODE is Not Valid!");
        }
        return vehicleService.getVehicle(vehicleCode);
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO dto) {
        try {
            vehicleService.saveVehicle(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{vehicleCode}")
    public ResponseEntity<Void> updateVehicle(@PathVariable("vehicleCode") String vehicleCode, @RequestBody VehicleDTO dto) {
        try {
            vehicleService.updateVehicle(vehicleCode, dto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{vehicleCode}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleCode") String vehicleCode) {
        try {
            vehicleService.deleteVehicle(vehicleCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (VehicleNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
