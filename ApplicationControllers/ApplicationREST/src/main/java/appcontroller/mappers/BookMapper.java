package appcontroller.mappers;



import appcontroller.modelDto.BookDto;
import model.Book;

import java.time.LocalDate;
import java.util.UUID;

public class BookMapper {
    public static Book convertBookDtoToBook(BookDto bookDto){
        return new Book(UUID.fromString(bookDto.getUuid()),bookDto.getTitle(),bookDto.getAuthorName(), LocalDate.parse(bookDto.getReleaseDate()));
    }
    public static BookDto convertBookToBookDto(Book book){
        BookDto bookDto = new BookDto(book.getTitle(),book.getAuthorName(), book.getReleaseDate().toString());
        bookDto.setUuid(book.getUuid().toString());
        return bookDto;
    }
}
