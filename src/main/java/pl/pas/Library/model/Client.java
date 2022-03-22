package pl.pas.Library.model;

public class Client extends User{
    public Client(String login, String address, String pesel, AccessLevel accessLevel) {
        super(login, address, pesel, accessLevel);
    }
}
