package exceptions;

public class BookNotUniqueIdException extends RuntimeException {
    public BookNotUniqueIdException(String message) {
        super(message);
    }
}
