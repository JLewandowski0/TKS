package model;

import java.util.UUID;

public class AdminUser extends User {
    public AdminUser(UUID uuid,String login, String address, String pesel, AccessLevel accessLevel) {
        super(uuid,login, address, pesel, accessLevel);
    }
}
