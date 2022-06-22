package EntityMapper;


import model.Rent;
import pl.tks.model.BookEnt;
import pl.tks.model.RentEnt;
import pl.tks.model.UserEnt;



public class RentMapper {
    BookMapper bookMapper;
    UserMapper userMapper;
    public RentEnt convertRentToRentEnt(Rent rent) {
        UserEnt user = userMapper.ConvertUserToUserEnt(rent.getClient());
        BookEnt book = bookMapper.ConvertBookToBookEnt(rent.getBook());
        return new RentEnt(rent.getStartDate(),user,book);
    }
}
