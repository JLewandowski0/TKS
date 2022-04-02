package EntityMapper;

import Entities.RentEntity;
import model.Book;
import model.Rent;
import model.User;
import services.BookService;
import services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;

@Stateless
public class RentMapper {

    @Inject
    BookService bookService;
    @Inject
    UserService userService;

    public Rent convertRentEntityToRent(RentEntity rentEntity) {
        User user = userService.getUser(rentEntity.getClientUuid());
        Book book = bookService.getBook(rentEntity.getBookUuid());
        return new Rent(LocalDate.parse(rentEntity.getStartDate()),user,book);
    }
}
