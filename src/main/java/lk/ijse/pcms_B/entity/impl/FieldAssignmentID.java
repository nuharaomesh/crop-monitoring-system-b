package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class FieldAssignmentID {
    private String fieldCode;
    private String staffID;
}
