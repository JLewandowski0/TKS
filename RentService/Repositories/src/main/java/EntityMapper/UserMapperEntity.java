package EntityMapper;

import RepoModel.*;
import model.User;


public class UserMapperEntity {
    public static UserEnt convertUserToUserEnt(User user){
        return new UserEnt(user.getUuid(),user.getLogin());
    }

}
