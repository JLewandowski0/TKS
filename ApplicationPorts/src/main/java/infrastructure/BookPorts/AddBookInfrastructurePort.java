package infrastructure.BookPorts;


import model.Book;

public interface AddBookInfrastructurePort {
    boolean add(Book book);
}
