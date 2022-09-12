package EntityMapper;


import RepoModel.BookEnt;
import RepoModel.RentEnt;
import RepoModel.UserEnt;
import model.Rent;

import static EntityMapper.BookMapperEntity.convertBookToBookEnt;
import static EntityMapper.UserMapperEntity.convertUserToUserEnt;


public class RentMapperEntity {
    public static RentEnt convertRentToRentEnt(Rent rent) {
        UserEnt user = convertUserToUserEnt(rent.getClient());
        BookEnt book = convertBookToBookEnt(rent.getBook());
        return new RentEnt(rent.getStartDate(),user,book);
    }
}
