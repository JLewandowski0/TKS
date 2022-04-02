package Repositiories;

import exceptions.BookNotUniqueIdException;
import pl.tks.model.BookEnt;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import static java.util.Collections.synchronizedList;

@ApplicationScoped
public class BookRepository implements Repository<BookEnt> {

    private final List<BookEnt> books = synchronizedList(new ArrayList<>());

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

    @Override
    public List<BookEnt> getAll(Predicate<BookEnt> predicate) {
        List<BookEnt> ret = new ArrayList<>();

        for (BookEnt c : books) {
            if (predicate.test(c) && !c.isArchived()) {
                ret.add(c);
            }
        }
        return ret;
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
