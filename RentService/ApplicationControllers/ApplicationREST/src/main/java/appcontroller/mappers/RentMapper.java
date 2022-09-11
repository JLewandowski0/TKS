package appcontroller.mappers;




import appcontroller.modelDto.BookDto;
import appcontroller.modelDto.RentDto;
import appcontroller.modelDto.UserDto;
import model.Book;
import model.Rent;
import model.User;

import java.time.LocalDate;


public class RentMapper {




    public static Rent convertRentDtoToRent(RentDto rentDto) {
        User user = UserMapper.convertUserDtoToUser(rentDto.getUser());
        Book book = BookMapper.convertBookDtoToBook(rentDto.getBook());
        return new Rent(rentDto.getStartDate(),user,book);
    }
    public static RentDto convertRentToRentDto(Rent rent) {
        UserDto user = UserMapper.convertUserToUserDto(rent.getUser());
        BookDto book = BookMapper.convertBookToBookDto(rent.getBook());
        RentDto rentDto= new RentDto(LocalDate.parse(rent.getStartDate().toString()),user,book);
        rentDto.setUuid(rent.getUuid());
        if(rentDto.getEndDate() != null)rentDto.setEndDate(LocalDate.parse(rent.getEndDate().toString()));
        return rentDto;
    }
}
