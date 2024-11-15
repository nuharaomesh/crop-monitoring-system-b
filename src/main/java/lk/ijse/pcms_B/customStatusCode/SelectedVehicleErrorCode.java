package lk.ijse.pcms_B.customStatusCode;

import lk.ijse.pcms_B.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedVehicleErrorCode implements VehicleStatus {
    private int statusCode;
    private String statusMessage;
}
