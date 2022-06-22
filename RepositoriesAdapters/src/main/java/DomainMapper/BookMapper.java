package DomainMapper;



import model.Book;
import pl.tks.model.BookEnt;

import java.time.LocalDate;


public class BookMapper {
    public Book ConvertBookEntToBook(BookEnt bookEnt){
        return new Book(bookEnt.getTitle(),bookEnt.getAuthorName(), LocalDate.parse(bookEnt.getReleaseDate().toString()));
    }

}
