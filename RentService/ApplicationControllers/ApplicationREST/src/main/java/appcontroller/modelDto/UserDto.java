package appcontroller.modelDto;


import java.util.UUID;

public class UserDto {

    private UUID uuid;
    private String login;

    public UserDto(UUID uuid ,String login) {
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
