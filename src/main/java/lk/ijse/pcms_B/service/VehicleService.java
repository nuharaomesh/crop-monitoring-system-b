package lk.ijse.pcms_B.service;

import lk.ijse.pcms_B.dto.VehicleStatus;
import lk.ijse.pcms_B.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleStatus getVehicle(String vehicleCode);
    List<VehicleDTO> getAllVehicles();
    void saveVehicle(VehicleDTO dto);
    void updateVehicle(String vehicleCode, VehicleDTO dto);
    void deleteVehicle(String vehicleID);
}
