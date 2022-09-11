package EntityMapper;

import RepoModel.*;
import model.*;


public class UserMapperEntity {
    public static UserEnt convertUserToUserEnt(User user){
        switch(user.getAccessLevel()){
            case "CLIENT":
                return new ClientEnt(user.getUuid(),user.getLogin(), user.getAddress(), user.getPesel(), AccessLevelEnt.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResourcesEnt(user.getUuid(),user.getLogin(), user.getAddress(), user.getPesel(), AccessLevelEnt.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUserEnt(user.getUuid(),user.getLogin(), user.getAddress(), user.getPesel(),AccessLevelEnt.ADMINUSER);
            default:
                return null;
        }

    }

}
