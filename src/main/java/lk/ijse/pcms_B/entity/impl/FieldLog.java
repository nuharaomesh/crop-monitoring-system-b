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
@Table(name = "Field_log")
public class FieldLog implements SuperEntity {
    @EmbeddedId
    private FieldLogID fieldLogID;
    private Date date;
    private String observationDetail;

    @ManyToOne
    @MapsId("fieldCode")
    @JoinColumn(name = "fieldCode", referencedColumnName = "fieldCode")
    private Field field;

    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private Logs logs;
}
