package exceptions;

public class UserUsedInCurrentRentException extends RuntimeException {
    public UserUsedInCurrentRentException(String message) {
        super(message);
    }
}
