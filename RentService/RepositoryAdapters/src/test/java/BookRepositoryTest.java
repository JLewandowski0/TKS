import Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {
    BookRepository bookRepository;
    @BeforeEach
    void init() {
       bookRepository = new BookRepository();
    }

    @Test
    void addBookTest(){
        int size = bookRepository.getAll().size();
        BookEnt bookEnt = new BookEnt(UUID.randomUUID(),"test","test", LocalDate.now());
        bookRepository.add(bookEnt);
        assertEquals(bookRepository.getAll().size(),size+1);
    }

    @Test
    void deleteBookTest(){
        int size = bookRepository.getAll().size();
        BookEnt bookEnt = new BookEnt(UUID.randomUUID(),"test","test", LocalDate.now());
        bookRepository.add(bookEnt);
        assertEquals(bookRepository.getAll().size(),size+1);
        bookRepository.remove(bookEnt);
        assertEquals(bookRepository.getAll().size(),size);
    }
    @Test
    void getBookTest(){
        BookEnt bookEnt = new BookEnt(UUID.randomUUID(),"test","test", LocalDate.now());
        bookRepository.add(bookEnt);
        assertEquals(bookRepository.get(bookEnt.getUuid()),bookEnt);
    }
}
