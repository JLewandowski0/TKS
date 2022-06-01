package Adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import Repositiories.BookRepository;
import infrastructure.BookPorts.AddBookInfrastructurePort;
import infrastructure.BookPorts.GetAllBookInfrastructurePort;
import infrastructure.BookPorts.GetBookInfrastructurePort;
import infrastructure.BookPorts.RemoveBookInfrastracturePort;
import model.Book;
import pl.tks.model.BookEnt;

import javax.inject.Inject;

public class BookRepositoryAdapter implements AddBookInfrastructurePort, GetBookInfrastructurePort, RemoveBookInfrastracturePort, GetAllBookInfrastructurePort {

    @Inject
    BookRepository bookRepository;
    DomainMapper.BookMapper bookDomainMapper;
    EntityMapper.BookMapper bookEntityMapper;
    @Override
    public Book get(UUID uuid){
        BookEnt book = bookRepository.get(uuid);
        return bookDomainMapper.ConvertBookEntToBook(book);
    }

    @Override
    public Book get(Predicate<Book> predicate) {
        List <BookEnt> bookEntList = bookRepository.getAll();
        for (BookEnt c : bookEntList){
            if (predicate.test(bookDomainMapper.ConvertBookEntToBook(c)) && !c.isArchived()) {
                return bookDomainMapper.ConvertBookEntToBook(c);
            }
        }
        return null;
    }

    public boolean add(Book book){
        BookEnt bookEnt = bookEntityMapper.ConvertBookToBookEnt(book);
        return bookRepository.add(bookEnt);
    }

    @Override
    public boolean remove(Book book){
        BookEnt bookEnt = bookEntityMapper.ConvertBookToBookEnt(book);
        return bookRepository.remove(bookEnt);
    }


    @Override
    public List<Book> getAll(Predicate<Book> predicate){

        List <BookEnt> bookEntList = bookRepository.getAll();
        List <Book> bookList = new ArrayList<>();
        for(BookEnt c : bookEntList){
            if (predicate.test(bookDomainMapper.ConvertBookEntToBook(c)) && !c.isArchived()) {
             bookList.add(bookDomainMapper.ConvertBookEntToBook(c));
            }
        }
        return bookList;
    }

    @Override
    public List<Book> getAll(){
       List <BookEnt> bookEntList = bookRepository.getAll();
       List <Book> bookList = new ArrayList<>();
       for(BookEnt c : bookEntList){
           bookList.add(bookDomainMapper.ConvertBookEntToBook(c));
       }
       return bookList;
    }


}
