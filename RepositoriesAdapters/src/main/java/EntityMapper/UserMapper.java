package EntityMapper;

import Entities.UserEntity;
import model.*;

import javax.ejb.Stateless;


@Stateless
public class UserMapper {
    public User ConvertUserEntityToUser(UserEntity userEntity){
        switch(userEntity.getAccessLevel()){
            case "CLIENT":
                return new Client(userEntity.getLogin(), userEntity.getAddress(), userEntity.getPesel(),AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResources(userEntity.getLogin(), userEntity.getAddress(), userEntity.getPesel(), AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUser(userEntity.getLogin(), userEntity.getAddress(), userEntity.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }

}
