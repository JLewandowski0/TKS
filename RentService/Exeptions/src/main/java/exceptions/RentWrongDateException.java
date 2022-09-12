package exceptions;

public class RentWrongDateException extends RuntimeException {
    public RentWrongDateException(String message) {
        super(message);
    }
}
