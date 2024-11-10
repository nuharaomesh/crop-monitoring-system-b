package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.pcms_B.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Logs")
public class Logs implements SuperEntity {
    @Id
    private String logCode;
    private Date date;
    private String details;
    private String observedImg;

    @OneToMany(mappedBy = "logs")
    private List<StaffLog> staffLogs;

    @OneToMany(mappedBy = "logs")
    private List<FieldLog> fieldLogs;

    @OneToMany(mappedBy = "logs")
    private List<CropLog> cropLogs;
}
