package Adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import Repositiories.BookRepository;
import infrastructurePorts.BookPorts.AddBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetAllBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetBookInfrastructurePort;
import infrastructurePorts.BookPorts.RemoveBookInfrastracturePort;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tks.model.BookEnt;

@Component
public class BookRepositoryAdapter implements AddBookInfrastructurePort, GetBookInfrastructurePort, RemoveBookInfrastracturePort, GetAllBookInfrastructurePort {

    @Autowired
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
