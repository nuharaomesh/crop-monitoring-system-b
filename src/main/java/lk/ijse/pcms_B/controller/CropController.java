package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedCropErrorCode;
import lk.ijse.pcms_B.dto.CropStatus;
import lk.ijse.pcms_B.dto.impl.CropDTO;
import lk.ijse.pcms_B.exception.CropNotFoundException;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.service.CropService;
import lk.ijse.pcms_B.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping(value = "/{cropID}")
    public CropStatus getCrop(@PathVariable("cropID") String cropCode) {
        if (cropCode.isEmpty() || cropCode == null) {
            return new SelectedCropErrorCode(1, "Crop ID is Not Valid!");
        }
        return cropService.getCrop(cropCode);
    }

    @GetMapping
    public List<CropDTO> getAllCrops() {
        return cropService.getAllCrops();
    }

    @PostMapping(value = "/saveCrop", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropName") String cropName,
            @RequestPart("cropScientificName") String cropScientificName,
            @RequestPart("cropImg") MultipartFile cropImg,
            @RequestPart("category") String category,
            @RequestPart("cropSeason") String cropSeason
    ) {
        try {
            byte[] bytesCropImg = cropImg.getBytes();

            String base64CropImg = AppUtil.imgToBase64(bytesCropImg);

            var buildCropDTO = new CropDTO();

            buildCropDTO.setCropName(cropName);
            buildCropDTO.setCropScientificName(cropScientificName);
            buildCropDTO.setCropImg(base64CropImg);
            buildCropDTO.setCategory(category);
            buildCropDTO.setCropSeason(cropSeason);
            cropService.saveCrop(buildCropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{cropCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCrop(
            @PathVariable("cropCode") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("cropScientificName") String cropScientificName,
            @RequestPart("cropImg") MultipartFile cropImg,
            @RequestPart("category") String category,
            @RequestPart("cropSeason") String cropSeason
    ) {
        try {
            byte[] bytesCropImg = cropImg.getBytes();

            String base64CropImg = AppUtil.imgToBase64(bytesCropImg);

            var buildCropDTO = new CropDTO();

            buildCropDTO.setCropName(cropName);
            buildCropDTO.setCropScientificName(cropScientificName);
            buildCropDTO.setCropImg(base64CropImg);
            buildCropDTO.setCategory(category);
            buildCropDTO.setCropSeason(cropSeason);
            cropService.updateCrop(cropCode, buildCropDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "/{cropCode}")
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode) {
        try {
            cropService.deleteCrop(cropCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
