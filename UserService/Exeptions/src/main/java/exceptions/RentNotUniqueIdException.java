package exceptions;

public class RentNotUniqueIdException extends RuntimeException {
    public RentNotUniqueIdException(String message) {
        super(message);
    }
}
