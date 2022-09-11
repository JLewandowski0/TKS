package Repository;

import exceptions.BookNotUniqueIdException;
import RepoModel.BookEnt;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Repository
public class BookRepository implements RepositoryInterface<BookEnt> {

    private final List<BookEnt> books;

    public BookRepository() {
        this.books = new ArrayList<>();
        this.add(new BookEnt(UUID.fromString("9f77375c-7d30-4eca-a830-aebec2ddd8a7"),"Pan Tadeusz", "Adam Mickiewicz", LocalDate.of(1805, 7, 5) ));
        this.add(new BookEnt(UUID.fromString("9f77375c-7d30-4eca-a830-aebec2ddd85d"),"W pustyni i w puszczy", "Henryk Sienkiewicz", LocalDate.of(1869, 7, 5) ));
        this.add(new BookEnt(UUID.fromString("759df6cf-66b2-4ea7-b20a-c93eee1d0e2b"),"Trójkąt Bermudzki", "Sebastian Alvarez", LocalDate.of(2022, 7, 5) ));
        this.add(new BookEnt(UUID.fromString("9f77375c-7d30-4eca-a830-aebec2ddd812"),"Ogniem i Mieczem", "Henryk Sienkiewicz", LocalDate.of(1900, 8, 19) ));
    }
    @Override
    public BookEnt get(UUID uuid) {
        for (BookEnt c : books) {
            if (c.getUuid().equals(uuid) && !c.isArchived()) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean add(BookEnt book){
        book.setUuid(UUID.randomUUID());
        if (book.getUuid() == null || this.get(book.getUuid()) != null) {
            throw new BookNotUniqueIdException("Book with given uuid already exist!");
        }
        return books.add(book);
    }

    @Override
    public boolean remove(BookEnt book) {
        book.setArchived();
        return true;
    }

    @Override
    public BookEnt get(Predicate<BookEnt> predicate) {
        for (BookEnt c : books) {
            if (predicate.test(c) && !c.isArchived()) {
                return c;
            }
        }
        return null;
    }


    public List<BookEnt> getAll() {
        List<BookEnt> ret = new ArrayList<>();

        for (BookEnt c : books) {
            if (!c.isArchived()) {
                ret.add(c);
            }
        }
        return ret;
    }

}
