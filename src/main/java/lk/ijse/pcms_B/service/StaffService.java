package lk.ijse.pcms_B.service;

import lk.ijse.pcms_B.dto.StaffStatus;
import lk.ijse.pcms_B.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    StaffStatus getStaff(String staffID);
    List<StaffDTO> getAllStaffs();
    void saveStaff(StaffDTO dto);
    void updateStaff(String staffID, StaffDTO dto);
    void deleteStaff(String staffID);
}
