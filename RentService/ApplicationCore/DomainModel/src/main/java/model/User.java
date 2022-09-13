package model;

import java.util.UUID;

public class User {

    private UUID uuid;
    private String login;

    public User(UUID uuid, String login) {
        this.uuid = uuid;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
