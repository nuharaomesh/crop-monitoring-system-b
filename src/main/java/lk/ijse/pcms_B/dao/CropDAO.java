package lk.ijse.pcms_B.dao;

import lk.ijse.pcms_B.entity.impl.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDAO extends JpaRepository<Crop, String> {}
