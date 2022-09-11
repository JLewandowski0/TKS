package exceptions;

public class RentRemoveAfterEndedException extends RuntimeException {
    public RentRemoveAfterEndedException(String message) {
        super(message);
    }
}
