package infrastructure.BookPorts;
import model.Book;

import java.util.function.Predicate;
import java.util.List;

public interface GetAllBookInfrastructurePort {
    List<Book> getAll();
}
