package RepoModel;

import java.util.UUID;

public class AdminUserEnt extends UserEnt {
    public AdminUserEnt(UUID uuid, String login, String address, String pesel, AccessLevelEnt accessLevel) {
        super(uuid,login, address, pesel, accessLevel);
    }
}
