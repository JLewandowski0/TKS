package DomainMapper;


import model.*;
import pl.tks.model.RentEnt;
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

    public Rent convertRentEntToRent(RentEnt rentEnt) {
        User user = userService.getUser(rentEnt.getClient().getUuid());
        Book book = bookService.getBook(rentEnt.getUuid());
        return new Rent(LocalDate.parse(rentEnt.getStartDate().toString()),user,book);
    }
}
