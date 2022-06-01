package pl.pas.Library.exceptions;

public class UserNotUniqueIdException extends RuntimeException {
    public UserNotUniqueIdException(String message) {
        super(message);
    }
}
