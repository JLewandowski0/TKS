package appcontroller.mappers;


import appcontroller.modelDto.UserDto;
import model.*;

import java.util.UUID;

public class UserMapper {
    public static User convertUserDtoToUser(UserDto userDto){
        if (userDto == null) return null;
        return new User(userDto.getUuid(),userDto.getLogin());

    }
    public static UserDto convertUserToUserDto(User user){
        if (user == null) return null;
        return new UserDto(user.getUuid(),user.getLogin());
    }

}
