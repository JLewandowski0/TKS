package pl.tks.model;

public class AdminUserEnt extends UserEnt {
    public AdminUserEnt(String login, String address, String pesel, AccessLevelEnt accessLevel) {
        super(login, address, pesel, accessLevel);
    }
}
