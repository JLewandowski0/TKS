package model;

import java.util.UUID;

public class AdminResources extends User{
    public AdminResources(UUID uuid,String login, String address, String pesel, AccessLevel accessLevel) {
        super(uuid, login, address, pesel, accessLevel);
    }
}
