package model;

import java.util.UUID;

public class Client extends User{
    public Client(UUID uuid,String login, String address, String pesel, AccessLevel accessLevel) {
        super(uuid,login, address, pesel, accessLevel);
    }
}
