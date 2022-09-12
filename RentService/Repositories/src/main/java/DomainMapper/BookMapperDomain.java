package DomainMapper;


import RepoModel.BookEnt;
import model.Book;

import java.time.LocalDate;


public class BookMapperDomain {
    public static  Book convertBookEntToBook(BookEnt bookEnt){
        return new Book(bookEnt.getUuid(),bookEnt.getTitle(),bookEnt.getAuthorName(), LocalDate.parse(bookEnt.getReleaseDate().toString()));
    }

}
