package infrastructure.BookPorts;

import model.Book;

import java.util.function.Predicate;

public interface GetBookPredicateInfrastructurePort {
    Book get(Predicate<Book> predicate);
}
