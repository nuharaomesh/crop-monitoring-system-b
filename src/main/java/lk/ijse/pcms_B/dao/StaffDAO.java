package lk.ijse.pcms_B.dao;

import lk.ijse.pcms_B.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDAO extends JpaRepository<Staff, String> {}
