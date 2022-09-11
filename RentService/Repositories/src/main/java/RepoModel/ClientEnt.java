package RepoModel;

import java.util.UUID;

public class ClientEnt extends UserEnt{
    public ClientEnt(UUID uuid,String login, String address, String pesel, AccessLevelEnt accessLevel) {
        super(uuid,login, address, pesel, accessLevel);
    }
}
