package pl.pas.Library.exceptions;

public class UserNotUniqueLoginException extends RuntimeException {
    public UserNotUniqueLoginException(String message) {
        super(message);
    }
}
