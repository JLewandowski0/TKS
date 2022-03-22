package pl.pas.Library.dto;

import pl.pas.Library.model.AccessLevel;
import pl.pas.Library.otherValidation.ValueOfEnum;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

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
    @ValueOfEnum(enumClass = AccessLevel.class)
    private String accessLevel;

    @JsonbCreator
    public UserDto(@JsonbProperty("login")String login, @JsonbProperty("address")String address, @JsonbProperty("pesel")String pesel, @JsonbProperty("accessLevel") String accessLevel) {
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
