package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Staff_log")
public class StaffLog implements SuperEntity {
    @EmbeddedId
    private StaffLogID staffLogID;
    private Date date;
    private String observationRole;
    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private Logs logs;

    @ManyToOne
    @MapsId("staffID")
    @JoinColumn(name = "staffID", referencedColumnName = "staffID")
    private Staff staff;
}
