package DomainMapper;

import RepoModel.UserEnt;
import model.*;


public class UserMapperDomain {
    public static User convertUserEntToUser(UserEnt userEnt){
       return new User(userEnt.getUuid(),userEnt.getLogin());
        }

    }

