package infrastructure.BookPorts;

import model.Book;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllBookPredicateInfrastructurePort {
    List<Book> getAll(Predicate<Book> predicate);
}
