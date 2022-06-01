package infrastructure.BookPorts;

import model.Book;

import java.util.UUID;
import java.util.function.Predicate;

public interface GetBookInfrastructurePort {
    Book get(UUID uuid);
    Book get(Predicate<Book> predicate);
}
