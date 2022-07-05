package appcontroller.modelDto;


import model.AccessLevel;

import java.util.UUID;

public class UserDto {

    private UUID uuid;
    private String login;
    private String address;
    private String pesel;
    private AccessLevel accessLevel;
    private boolean active = true;

    public UserDto(UUID uuid ,String login, String address, String pesel, AccessLevel accessLevel) {
        this.uuid = uuid;
        this.login = login;
        this.address = address;
        this.pesel = pesel;
        this.accessLevel = accessLevel;
    }

    public String getLogin() {
        return login;
    }

    public String getAddress() {
        return address;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAccessLevel() {
        return accessLevel.getAccessLevel();
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void changeActivity() {
        this.active = !this.active;
    }

}