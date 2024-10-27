package lk.ijse.pcms_B.dto.impl;

import lk.ijse.pcms_B.dto.VehicleStatus;
import lk.ijse.pcms_B.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    private String vehicleCode;
    private String licencePlateNumber;
    private String category;
    private String fuelType;
    private Availability status;
    private String remarks;
}
