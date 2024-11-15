package lk.ijse.pcms_B.customStatusCode;

import lk.ijse.pcms_B.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedCropErrorCode implements CropStatus {
    private int statusCode;
    private String statusMessage;
}
