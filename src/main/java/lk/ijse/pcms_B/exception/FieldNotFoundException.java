package lk.ijse.pcms_B.exception;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException() {
        super();
    }

    public FieldNotFoundException(String message) {
        super(message);
    }

    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
