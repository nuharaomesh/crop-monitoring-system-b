package lk.ijse.pcms_B.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String genEquipmentID() {
        return "EQUIPMENT-" + UUID.randomUUID();
    }

    public static String genFieldCode() {
        return "FIELD_CODE-" + UUID.randomUUID();
    }

    public static String genCropCode() {
        return "CROP_CODE-" + UUID.randomUUID();
    }

    public static String imgToBase64(byte[] byteImg) {
        return Base64.getEncoder().encodeToString(byteImg);
    }
}
