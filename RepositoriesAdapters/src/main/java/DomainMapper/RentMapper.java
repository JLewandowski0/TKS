package DomainMapper;



import model.*;
import pl.tks.model.RentEnt;

import java.time.LocalDate;


public class RentMapper {

    BookMapper bookMapper;

    UserMapper userMapper;
    public Rent convertRentEntToRent(RentEnt rentEnt) {
        User user = userMapper.ConvertUserEntToUser(rentEnt.getClient());
        Book book = bookMapper.ConvertBookEntToBook(rentEnt.getBook());
        return new Rent(LocalDate.parse(rentEnt.getStartDate().toString()),user,book);
    }
}
