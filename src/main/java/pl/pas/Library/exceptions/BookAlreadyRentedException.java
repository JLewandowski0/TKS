package pl.pas.Library.exceptions;

public class BookAlreadyRentedException extends RuntimeException {
    public BookAlreadyRentedException(String message) {
        super(message);
    }
}
