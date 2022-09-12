package Adapters;

import DomainMapper.BookMapperDomain;
import EntityMapper.BookMapperEntity;
import RepoModel.BookEnt;
import Repository.BookRepository;
import infrastructurePorts.BookPorts.AddBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetAllBookInfrastructurePort;
import infrastructurePorts.BookPorts.GetBookInfrastructurePort;
import infrastructurePorts.BookPorts.RemoveBookInfrastracturePort;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Component
public class BookRepositoryAdapter implements AddBookInfrastructurePort, GetBookInfrastructurePort, RemoveBookInfrastracturePort, GetAllBookInfrastructurePort {

    @Autowired
    BookRepository bookRepository;
    @Override
    public Book get(UUID uuid){
        BookEnt book = bookRepository.get(uuid);
        return BookMapperDomain.convertBookEntToBook(book);
    }

    @Override
    public Book get(Predicate<String> predicate) {
        List <BookEnt> bookEntList = bookRepository.getAll();
        for (BookEnt c : bookEntList){
            if (predicate.test(BookMapperDomain.convertBookEntToBook(c).getTitle()) && !c.isArchived()) {
                return BookMapperDomain.convertBookEntToBook(c);
            }
        }
        return null;
    }

    public boolean add(Book book){
        BookEnt bookEnt = BookMapperEntity.convertBookToBookEnt(book);
        return bookRepository.add(bookEnt);
    }

    @Override
    public boolean remove(Book book){
        BookEnt bookEnt = BookMapperEntity.convertBookToBookEnt(book);
        return bookRepository.remove(bookEnt);
    }


    @Override
    public List<Book> getAll(Predicate<Book> predicate){

        List <BookEnt> bookEntList = bookRepository.getAll();
        List <Book> bookList = new ArrayList<>();
        for(BookEnt c : bookEntList){
            if (predicate.test(BookMapperDomain.convertBookEntToBook(c)) && !c.isArchived()) {
             bookList.add(BookMapperDomain.convertBookEntToBook(c));
            }
        }
        return bookList;
    }

    @Override
    public List<Book> getAll(){
       List <BookEnt> bookEntList = bookRepository.getAll();
       List <Book> bookList = new ArrayList<>();
       for(BookEnt c : bookEntList){
           bookList.add(BookMapperDomain.convertBookEntToBook(c));
       }
       return bookList;
    }


}
