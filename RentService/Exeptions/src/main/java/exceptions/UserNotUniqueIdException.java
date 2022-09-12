package exceptions;

public class UserNotUniqueIdException extends RuntimeException {
    public UserNotUniqueIdException(String message) {
        super(message);
    }
}
