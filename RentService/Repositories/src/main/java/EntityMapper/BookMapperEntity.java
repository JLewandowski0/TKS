package EntityMapper;

import model.Book;
import RepoModel.BookEnt;


public class BookMapperEntity {
    public static BookEnt convertBookToBookEnt(Book book){
        return new BookEnt(book.getUuid(),book.getTitle(), book.getAuthorName(), book.getReleaseDate());
    }

}
