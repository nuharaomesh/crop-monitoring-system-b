package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lk.ijse.pcms_B.enums.GrowthStage;
import lk.ijse.pcms_B.enums.HarvestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Cultivate")
public class Cultivate implements SuperEntity {
    @Id
    private String cultivateID;
    private Date plantingDate;
    private Date expectedHarvestDate;
    @Enumerated(EnumType.STRING)
    private GrowthStage growthStage;
    @Enumerated(EnumType.STRING)
    private HarvestStatus status;
    @ManyToOne
    @JoinColumn(name = "cropID", nullable = false)
    private Crop crop;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private Field field;
}
