package lk.ijse.pcms_B.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pcms_B.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Crop")
public class Crop implements SuperEntity {
    @Id
    private String cropCode;
    private String cropName;
    private String cropScientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImg;
    private String category;
    private String cropSeason;
    private String cropTimeRange;
    @OneToMany(mappedBy = "crop")
    private List<Cultivate> cultivates;
    @OneToMany(mappedBy = "crop")
    private List<CropLog> cropLogs;
}
