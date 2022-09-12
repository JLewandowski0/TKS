package infrastructurePorts.BookPorts;

import model.Book;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllBookInfrastructurePort {
    List<Book> getAll();
    List<Book> getAll(Predicate<Book> predicate);
}
