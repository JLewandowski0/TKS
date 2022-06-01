package services;


import exceptions.*;
import infrastructure.BookPorts.*;
import model.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Stateless
public class BookService {

    @Inject
    RentService rentService;
    @Inject
    GetBookPredicateInfrastructurePort getBookPredicateInfrastructurePort;
    @Inject
    GetAllBookPredicateInfrastructurePort getAllBookPredicateInfrastructurePort;
    @Inject
    GetAllBookInfrastructurePort getAllBookInfrastructurePort;
    @Inject
    GetBookInfrastructurePort getBookInfrastructurePort;
    @Inject
    RemoveBookInfrastracturePort removeBookInfrastracturePort;
    @Inject
    AddBookInfrastructurePort addBookInfrastructurePort;

    public Book addBook(Book book){
        addBookInfrastructurePort.add(book);
        return book;
    }

    public Book getBook(UUID id)  {
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

    public void removeBook(UUID uuid){
        Book book = getBookInfrastructurePort.get(uuid);
        if (book == null) {
            throw new BookNotFoundException("There is no book with given id!");
        }
        if (rentService.getAllRentPredicateInfrastructurePort.getAll(x -> x.getBook().getUuid().equals(uuid) && x.getEndDate() == null).size() != 0) {
            throw new BookAlreadyRentedException("You cannot remove rented book!");
        }
        removeBookInfrastracturePort.remove(book);

    }

}
