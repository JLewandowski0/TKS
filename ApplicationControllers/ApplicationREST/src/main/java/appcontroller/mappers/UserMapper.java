package appcontroller.mappers;


import appcontroller.modelDto.UserDto;
import model.*;

import java.util.UUID;

public class UserMapper {
    public static User convertUserDtoToUser(UserDto userDto){
        if (userDto == null) return null;
        switch(userDto.getAccessLevel()){
            case "CLIENT":
                return new Client(userDto.getUuid(),userDto.getLogin(),userDto.getAddress(),userDto.getPesel(), AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResources(userDto.getUuid(),userDto.getLogin(),userDto.getAddress(),userDto.getPesel(),AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUser(userDto.getUuid(),userDto.getLogin(),userDto.getAddress(),userDto.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }
    public static UserDto convertUserToUserDto(User user){
        if (user == null) return null;
        switch(user.getAccessLevel()){
            case "CLIENT":
                return new UserDto(user.getUuid(),user.getLogin(),user.getAddress(),user.getPesel(), AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new UserDto(user.getUuid(),user.getLogin(),user.getAddress(),user.getPesel(),AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new UserDto(user.getUuid(),user.getLogin(),user.getAddress(),user.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }

}
