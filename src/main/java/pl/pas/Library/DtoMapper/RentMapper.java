package pl.pas.Library.DtoMapper;

import pl.pas.Library.dto.RentDto;
import pl.pas.Library.managers.BookManager;
import pl.pas.Library.managers.UserManager;
import pl.pas.Library.model.Book;
import pl.pas.Library.model.Rent;
import pl.pas.Library.model.User;
import pl.pas.Library.repositories.BookRepository;
import pl.pas.Library.repositories.UserRepository;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;

@Stateless
public class RentMapper {

    @Inject
    BookManager bookManager;
    @Inject
    UserManager userManager;

    public Rent convertRentDtoToRent(RentDto rentDto) {
        User user = userManager.getUser(rentDto.getClientUuid());
        Book book = bookManager.getBook(rentDto.getBookUuid());
        return new Rent(LocalDate.parse(rentDto.getStartDate()),user,book);
    }
}
