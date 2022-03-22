package pl.pas.Library.DtoMapper;

import pl.pas.Library.dto.UserDto;
import pl.pas.Library.model.*;

import javax.ejb.Stateless;


@Stateless
public class UserMapper {
    public User ConvertUserDtoToUser(UserDto userDto){
        switch(userDto.getAccessLevel()){
            case "CLIENT":
                return new Client(userDto.getLogin(),userDto.getAddress(),userDto.getPesel(),AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResources(userDto.getLogin(),userDto.getAddress(),userDto.getPesel(),AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUser(userDto.getLogin(),userDto.getAddress(),userDto.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }

}
