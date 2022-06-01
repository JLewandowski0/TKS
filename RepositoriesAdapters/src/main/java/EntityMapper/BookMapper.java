package EntityMapper;

import model.Book;
import pl.tks.model.BookEnt;

import javax.ejb.Stateless;

@Stateless
public class BookMapper {
    public BookEnt ConvertBookToBookEnt(Book book){
        return new BookEnt(book.getTitle(), book.getAuthorName(), book.getReleaseDate());
    }

}
