package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lk.ijse.pcms_B.enums.CropCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Crop_log")
public class CropLog implements SuperEntity {
    @EmbeddedId
    private CropLogID cropLogID;
    private Date date;
    private String note;
    @Enumerated(EnumType.STRING)
    private CropCondition conditions;

    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private Logs logs;

    @ManyToOne
    @MapsId("cropCode")
    @JoinColumn(name = "cropCode", referencedColumnName = "cropCode")
    private Crop crop;
}
