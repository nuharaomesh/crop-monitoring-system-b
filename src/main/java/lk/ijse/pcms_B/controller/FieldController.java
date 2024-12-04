package lk.ijse.pcms_B.controller;

import lk.ijse.pcms_B.customStatusCode.SelectedFieldErrorCode;
import lk.ijse.pcms_B.dto.FieldStatus;
import lk.ijse.pcms_B.dto.impl.FieldDTO;
import lk.ijse.pcms_B.exception.DataPersistException;
import lk.ijse.pcms_B.exception.FieldNotFoundException;
import lk.ijse.pcms_B.service.FieldService;
import lk.ijse.pcms_B.util.AppUtil;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping(value = "/{fieldCode}")
    public FieldStatus getField(@PathVariable("fieldCode") String fieldCode) {
        if (fieldCode.isEmpty() || fieldCode == null) {
            return new SelectedFieldErrorCode(1, "Field ID is Not Valid!");
        }
        return fieldService.getField(fieldCode);
    }

    @GetMapping
    public List<FieldDTO> getAllFields() {
        return fieldService.getAllFields();
    }

    @PostMapping(value = "/saveField", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldSize") String fieldSize,
            @RequestPart("fieldLocation") String location,
            @RequestPart("address") String address,
            @RequestPart("fieldImg1") MultipartFile img1,
            @RequestPart("fieldImg2") MultipartFile img2
    ) {
        System.out.println("asd");
        try {
            byte[] byteImg1 = img1.getBytes();
            byte[] byteImg2 = img2.getBytes();

            String base64Img1 = AppUtil.imgToBase64(byteImg1);
            String base64Img2 = AppUtil.imgToBase64(byteImg2);

            var buildFieldDTO = new FieldDTO();

            buildFieldDTO.setFieldName(fieldName);
            buildFieldDTO.setFieldLocation(location);
            buildFieldDTO.setFieldAddress(address);
            buildFieldDTO.setFieldSize(fieldSize);
            buildFieldDTO.setImg1(base64Img1);
            buildFieldDTO.setImg2(base64Img2);
            fieldService.saveField(buildFieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{fieldCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateField(
            @PathVariable("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldLocation") String location,
            @RequestPart("address") String address,
            @RequestPart("fieldSize") String fieldSize,
            @RequestPart("img1") MultipartFile img1,
            @RequestPart("img2") MultipartFile img2
    ) {
        try {
            byte[] byteImg1 = img1.getBytes();
            byte[] byteImg2 = img2.getBytes();

            String base64Img1 = AppUtil.imgToBase64(byteImg1);
            String base64Img2 = AppUtil.imgToBase64(byteImg2);

            var buildFieldDTO = new FieldDTO();

            buildFieldDTO.setFieldName(fieldName);
            buildFieldDTO.setFieldLocation(location);
            buildFieldDTO.setFieldAddress(address);
            buildFieldDTO.setFieldSize(fieldSize);
            buildFieldDTO.setImg1(base64Img1);
            buildFieldDTO.setImg2(base64Img2);
            fieldService.updateField(fieldCode, buildFieldDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{fieldCode}")
    public ResponseEntity<Void> deleteField(@PathVariable("fieldCode") String fieldCode) {
        try {
            fieldService.deleteField(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
