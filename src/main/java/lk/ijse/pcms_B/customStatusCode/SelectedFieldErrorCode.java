package lk.ijse.pcms_B.customStatusCode;

import lk.ijse.pcms_B.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedFieldErrorCode implements FieldStatus {
    private int statusCode;
    private String statusMessage;
}
