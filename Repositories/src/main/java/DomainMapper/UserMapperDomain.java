package DomainMapper;

import RepoModel.UserEnt;
import model.*;


public class UserMapperDomain {
    public static User convertUserEntToUser(UserEnt userEnt){
        switch(userEnt.getAccessLevel()){
            case "CLIENT":
                return new Client(userEnt.getUuid(),userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResources(userEnt.getUuid(),userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUser(userEnt.getUuid(),userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }

}
