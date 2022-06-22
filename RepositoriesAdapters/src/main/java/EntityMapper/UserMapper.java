package EntityMapper;

import model.*;
import pl.tks.model.*;


public class UserMapper {
    public UserEnt ConvertUserToUserEnt(User user){
        switch(user.getAccessLevel()){
            case "CLIENT":
                return new ClientEnt(user.getLogin(), user.getAddress(), user.getPesel(), AccessLevelEnt.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResourcesEnt(user.getLogin(), user.getAddress(), user.getPesel(), AccessLevelEnt.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUserEnt(user.getLogin(), user.getAddress(), user.getPesel(),AccessLevelEnt.ADMINUSER);
            default:
                return null;
        }

    }

}
