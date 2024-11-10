package lk.ijse.pcms_B.dao;

import lk.ijse.pcms_B.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<Field, String> {}
