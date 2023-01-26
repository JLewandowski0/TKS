package appcontroller.modelDto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class UserDto implements Serializable {

    private UUID uuid;
    private String login;

    public UserDto(@JsonProperty("uuid") UUID uuid ,
                   @JsonProperty("login") String login) {
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
