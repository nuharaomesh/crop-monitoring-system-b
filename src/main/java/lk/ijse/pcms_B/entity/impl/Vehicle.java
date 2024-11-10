package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lk.ijse.pcms_B.enums.VehicleStat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Vehicle")
public class Vehicle implements SuperEntity {
    @Id
    private String vehicleCode;
    private String licencePlateNumber;
    private String category;
    private String fuelType;
    @Enumerated(EnumType.STRING)
    private VehicleStat status;
    private String remarks;
    @OneToMany(mappedBy = "vehicle")
    private List<StaffAssignment> staffAssignments;
}
