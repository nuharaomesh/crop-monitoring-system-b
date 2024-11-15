package lk.ijse.pcms_B.customStatusCode;

import lk.ijse.pcms_B.dto.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedStaffErrorCode implements StaffStatus {
    private int statusCode;
    private String statusMessage;
}
