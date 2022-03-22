package pl.pas.Library.model;

public class AdminResources extends User{
    public AdminResources(String login, String address, String pesel, AccessLevel accessLevel) {
        super(login, address, pesel, accessLevel);
    }
}
