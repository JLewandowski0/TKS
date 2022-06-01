package EntityMapper;

import model.Book;
import model.Rent;
import model.User;
import pl.tks.model.BookEnt;
import pl.tks.model.RentEnt;
import pl.tks.model.UserEnt;
import services.BookService;
import services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RentMapper {
    @Inject
    BookMapper bookMapper;
    @Inject
    UserMapper userMapper;
    @Inject
    BookService bookService;
    @Inject
    UserService userService;

    public RentEnt convertRentToRentEnt(Rent rent) {
        UserEnt user = userMapper.ConvertUserToUserEnt(userService.getUser(rent.getClient().getUuid()));
        BookEnt book = bookMapper.ConvertBookToBookEnt(bookService.getBook(rent.getBook().getUuid()));
        return new RentEnt(rent.getStartDate(),user,book);
    }
}
