package services;


import exceptions.BookAlreadyRentedException;
import exceptions.BookNotFoundException;
import infrastructurePorts.BookPorts.AddBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetAllBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetBookInfrastructurePort;
import infrastructurePorts.BookPorts.RemoveBookInfrastracturePort;
import infrastructurePorts.RentPorts.GetAllRentInfrastructurePort;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final GetAllBookInfrastructurePort getAllBookInfrastructurePort;

    private final GetBookInfrastructurePort getBookInfrastructurePort;

    private final RemoveBookInfrastracturePort removeBookInfrastracturePort;

    private final AddBookInfrastructurePort addBookInfrastructurePort;

    private final GetAllRentInfrastructurePort getAllRentInfrastructurePort;
    @Autowired
    public BookService(GetAllBookInfrastructurePort getAllBookInfrastructurePort, GetBookInfrastructurePort getBookInfrastructurePort, RemoveBookInfrastracturePort removeBookInfrastracturePort, AddBookInfrastructurePort addBookInfrastructurePort, GetAllRentInfrastructurePort getAllRentInfrastructurePort) {
        this.getAllBookInfrastructurePort = getAllBookInfrastructurePort;
        this.getBookInfrastructurePort = getBookInfrastructurePort;
        this.removeBookInfrastracturePort = removeBookInfrastracturePort;
        this.addBookInfrastructurePort = addBookInfrastructurePort;
        this.getAllRentInfrastructurePort = getAllRentInfrastructurePort;
    }
    public boolean addBook(Book book){
        return addBookInfrastructurePort.add(book);
    }

    public Book getBook(UUID id) {
        Book book = getBookInfrastructurePort.get(id);
        if (book == null) {
            throw new BookNotFoundException("There is no book with given id!");
        }
        return book;
    }

    public List<Book> getAllBooks() {
        return getAllBookInfrastructurePort.getAll();
    }

    public void updateBook(UUID uuid, Book UpdatedBook){
        Book book = getBookInfrastructurePort.get(uuid);
        if (book == null) {
            throw new BookNotFoundException("There is no book with given id!");
        }
        book.setTitle(UpdatedBook.getTitle());
        book.setAuthorName(UpdatedBook.getAuthorName());
        book.setReleaseDate(UpdatedBook.getReleaseDate());
    }

    public boolean removeBook(UUID uuid){
        Book book = getBookInfrastructurePort.get(uuid);
        if (book == null) {
            throw new BookNotFoundException("There is no book with given id!");
        }
        if (getAllRentInfrastructurePort.getAll(x -> x.getBook().getUuid().equals(uuid) && x.getEndDate() == null).size() != 0) {
            throw new BookAlreadyRentedException("You cannot remove rented book!");
        }
        removeBookInfrastracturePort.remove(book);
        return true;
    }

}
