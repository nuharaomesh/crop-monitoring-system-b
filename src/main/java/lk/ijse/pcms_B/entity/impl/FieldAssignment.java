package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lk.ijse.pcms_B.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Field_assignment")
public class FieldAssignment implements SuperEntity {
    @EmbeddedId
    private FieldAssignmentID fieldAssignmentID;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Availability status;

    @ManyToOne
    @MapsId("staffID")
    @JoinColumn(name = "staffID", referencedColumnName = "staffID")
    private Staff staff;

    @ManyToOne
    @MapsId("fieldCode")
    @JoinColumn(name = "fieldCode", referencedColumnName = "fieldCode")
    private Field field;
}
