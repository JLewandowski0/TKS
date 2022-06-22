package DomainMapper;

import model.*;

import pl.tks.model.UserEnt;




public class UserMapper {
    public User ConvertUserEntToUser(UserEnt userEnt){
        switch(userEnt.getAccessLevel()){
            case "CLIENT":
                return new Client(userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.CLIENT);
            case "ADMINRESOURCES":
                return new AdminResources(userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.ADMINRESOURCES);
            case "ADMINUSER":
                return new AdminUser(userEnt.getLogin(),userEnt.getAddress(),userEnt.getPesel(),AccessLevel.ADMINUSER);
            default:
                return null;
        }

    }

}
