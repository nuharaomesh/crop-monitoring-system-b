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
@Table(name = "Field")
public class Field implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String fieldSize;
    @Column(columnDefinition = "LONGTEXT")
    private String img1;
    @Column(columnDefinition = "LONGTEXT")
    private String img2;
    @OneToMany(mappedBy = "field")
    private List<Cultivate> cultivate;
    @OneToMany(mappedBy = "field")
    private List<FieldAssignment> fieldAssignments;
    @OneToMany(mappedBy = "field")
    private List<FieldLog> fieldLogs;
}
