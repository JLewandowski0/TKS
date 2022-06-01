package model;

public class AdminUser extends User {
    public AdminUser(String login, String address, String pesel, AccessLevel accessLevel) {
        super(login, address, pesel, accessLevel);
    }
}
