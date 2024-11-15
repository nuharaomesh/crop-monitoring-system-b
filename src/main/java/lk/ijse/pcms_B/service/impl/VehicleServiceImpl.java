package lk.ijse.pcms_B.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pcms_B.customStatusCode.SelectedVehicleErrorCode;
import lk.ijse.pcms_B.dao.VehicleDAO;
import lk.ijse.pcms_B.dto.VehicleStatus;
import lk.ijse.pcms_B.dto.impl.VehicleDTO;
import lk.ijse.pcms_B.entity.impl.Vehicle;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.VehicleNotFoundException;
import lk.ijse.pcms_B.service.VehicleService;
import lk.ijse.pcms_B.util.AppUtil;
import lk.ijse.pcms_B.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public VehicleStatus getVehicle(String vehicleCode) {
        if (vehicleDAO.existsById(vehicleCode)) {
            Vehicle selectedVehicle = vehicleDAO.getReferenceById(vehicleCode);
            return mapping.toVehicleDTO(selectedVehicle);
        } else {
            return new SelectedVehicleErrorCode(2, "Selected Vehicle not found!");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapping.toVehicleDTOList(vehicleDAO.findAll());
    }

    @Override
    public void saveVehicle(VehicleDTO dto) {
        dto.setVehicleCode(AppUtil.genVehicleCode());
        Vehicle savedVehicle =
                vehicleDAO.save(mapping.toVehicleEntity(dto));
        if (savedVehicle == null) throw new DataPersistException("Vehicle Not saved!")
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO dto) {
        Optional<Vehicle> tmpVehicle = vehicleDAO.findById(vehicleCode);
        if (!tmpVehicle.isPresent()) {
            throw new VehicleNotFoundException("Vehicle Not Found!")
        } else {
            tmpVehicle.get().setLicencePlateNumber(dto.getLicencePlateNumber());
            tmpVehicle.get().setCategory(dto.getCategory());
            tmpVehicle.get().setFuelType(dto.getFuelType());
            tmpVehicle.get().setStatus(dto.getStatus());
            tmpVehicle.get().setRemarks(dto.getRemarks());
        }
    }

    @Override
    public void deleteVehicle(String vehicleCode) {
        Optional<Vehicle> tmpVehicle = vehicleDAO.findById(vehicleCode);
        if (!tmpVehicle.isPresent()) {
            throw new VehicleNotFoundException("Vehicle Not Found!");
        } else {
            vehicleDAO.deleteById(vehicleCode);
        }
    }
}
