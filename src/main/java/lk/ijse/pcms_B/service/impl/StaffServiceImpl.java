package lk.ijse.pcms_B.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pcms_B.customStatusCode.SelectedStaffErrorCode;
import lk.ijse.pcms_B.dao.StaffDAO;
import lk.ijse.pcms_B.dto.StaffStatus;
import lk.ijse.pcms_B.dto.impl.StaffDTO;
import lk.ijse.pcms_B.entity.impl.Staff;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.StaffNotFoundException;
import lk.ijse.pcms_B.service.StaffService;
import lk.ijse.pcms_B.util.AppUtil;
import lk.ijse.pcms_B.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public StaffStatus getStaff(String staffID) {
        if (staffDAO.existsById(staffID)) {
            Staff selectedStaff = staffDAO.getReferenceById(staffID);
            return mapping.toStaffDTO(selectedStaff);
        } else {
            return new SelectedStaffErrorCode(2, "Selected Staff not found!");
        }
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return mapping.toStaffList(staffDAO.findAll());
    }

    @Override
    public void saveStaff(StaffDTO dto) {
        dto.setStaffId(AppUtil.genStaffID());
        Staff savedStaff =
                staffDAO.save(mapping.toStaffEntity(dto));
        if (savedStaff == null) throw new DataPersistException("Staff Not Found!");
    }

    @Override
    public void updateStaff(String staffID, StaffDTO dto) {
        Optional<Staff> tmpStaff = staffDAO.findById(staffID);
        if (!tmpStaff.isPresent()) {
            throw new StaffNotFoundException("Staff Not Found!");
        } else {
            tmpStaff.get().setFirstName(dto.getFirstName());
            tmpStaff.get().setLastName(dto.getLastName());
            tmpStaff.get().setDesignation(dto.getDesignation());
            tmpStaff.get().setGender(dto.getGender());
            tmpStaff.get().setJoinedDate(dto.getJoinedDate());
            tmpStaff.get().setDob(dto.getDob());
            tmpStaff.get().setAddressLine1(dto.getAddressLine1());
            tmpStaff.get().setAddressLine2(dto.getAddressLine2());
            tmpStaff.get().setAddressLine3(dto.getAddressLine3());
            tmpStaff.get().setAddressLine4(dto.getAddressLine4());
            tmpStaff.get().setAddressLine5(dto.getAddressLine5());
            tmpStaff.get().setContactNo(dto.getContactNo());
            tmpStaff.get().setEmail(dto.getEmail());
            tmpStaff.get().setRole(dto.getRole());
        }
    }

    @Override
    public void deleteStaff(String staffID) {
        Optional<Staff> tmpStaff = staffDAO.findById(staffID);
        if (!tmpStaff.isPresent()) {
            throw new StaffNotFoundException("Staff Not Found!");
        } else {
            staffDAO.deleteById(staffID);
        }
    }
}
