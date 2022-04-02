package EntityMapper;

import Entities.BookEntity;
import model.Book;

import javax.ejb.Stateless;
import java.time.LocalDate;

@Stateless
public class BookMapper {
    public Book ConvertBookEntityToBook(BookEntity bookEntity){
        return new Book(bookEntity.getTitle(), bookEntity.getAuthorName(), LocalDate.parse(bookEntity.getReleaseDate()));
    }

}
