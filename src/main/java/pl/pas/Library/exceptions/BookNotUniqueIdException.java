package pl.pas.Library.exceptions;

public class BookNotUniqueIdException extends RuntimeException {
    public BookNotUniqueIdException(String message) {
        super(message);
    }
}
