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
@Table(name = "Staff_assignment")
public class StaffAssignment implements SuperEntity {
    @EmbeddedId
    private StaffAssignmentID staffAssignmentID;
    private Date assignmentDate;
    private String role;
    private Availability status;

    @ManyToOne
    @MapsId("staffID")
    @JoinColumn(name = "staffID", referencedColumnName = "staffID")
    private Staff staff;

    @ManyToOne
    @MapsId("vehicleCode")
    @JoinColumn(name = "vehicleCode", referencedColumnName = "vehicleCode")
    private Vehicle vehicle;
}
