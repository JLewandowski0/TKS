package DomainMapper;


import RepoModel.RentEnt;
import model.Book;
import model.Rent;
import model.User;

import java.time.LocalDate;

import static DomainMapper.BookMapperDomain.convertBookEntToBook;
import static DomainMapper.UserMapperDomain.convertUserEntToUser;


public class RentMapperDomain {


    public static Rent convertRentEntToRent(RentEnt rentEnt) {
        User user = convertUserEntToUser(rentEnt.getClient());
        Book book = convertBookEntToBook(rentEnt.getBook());
        Rent rent = new Rent(LocalDate.parse(rentEnt.getStartDate().toString()),user,book);
        rent.setUuid(rentEnt.getUuid());
        if(rent.getEndDate() != null)rent.setEndDate(LocalDate.parse(rentEnt.getEndDate().toString()));
        return rent;
    }
}
