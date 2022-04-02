package Entities;

import otherValidation.ValueOfEnum;
import pl.tks.model.AccessLevelEnt;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserEntity {

    @NotNull
    @Size(min = 5)
    private String login;

    @NotNull
    @Size(min = 5)
    private String address;

    @NotNull
    @Pattern(regexp="[\\d]{11}")
    private String pesel;

    @NotNull
    @ValueOfEnum(enumClass = AccessLevelEnt.class)
    private String accessLevel;

    @JsonbCreator
    public UserEntity(@JsonbProperty("login")String login, @JsonbProperty("address")String address, @JsonbProperty("pesel")String pesel, @JsonbProperty("accessLevel") String accessLevel) {
        this.login = login;
        this.address = address;
        this.pesel = pesel;
        this.accessLevel = accessLevel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
