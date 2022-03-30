package pl.tks.model;

public class ClientEnt extends UserEnt{
    public ClientEnt(String login, String address, String pesel, AccessLevelEnt accessLevel) {
        super(login, address, pesel, accessLevel);
    }
}
