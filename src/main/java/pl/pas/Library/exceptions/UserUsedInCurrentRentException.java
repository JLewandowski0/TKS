package pl.pas.Library.exceptions;

public class UserUsedInCurrentRentException extends RuntimeException {
    public UserUsedInCurrentRentException(String message) {
        super(message);
    }
}
