package EntityMapper;

import RepoModel.BookEnt;
import model.Book;


public class BookMapperEntity {
    public static BookEnt convertBookToBookEnt(Book book){
        return new BookEnt(book.getUuid(),book.getTitle(), book.getAuthorName(), book.getReleaseDate());
    }

}
