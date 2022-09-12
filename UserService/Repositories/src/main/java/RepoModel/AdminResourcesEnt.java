package RepoModel;

import java.util.UUID;

public class AdminResourcesEnt extends UserEnt{
    public AdminResourcesEnt(UUID uuid, String login, String address, String pesel, AccessLevelEnt accessLevel) {
        super(uuid,login, address, pesel, accessLevel);
    }
}
