import io.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

public class UserControllerTest implements SpringTest{
    @LocalServerPort
    private int port;

    private String URL;

    @PostConstruct
    private void init() {
        URL = BASE_URL + port + "/";
    }

    @Test
    public void create() throws JSONException {
        JSONObject jsonObject = new JSONObject("{\"accessLevel\":\"CLIENT\",\"login\":\"login5\",\"address\":\"addres5\",\"pesel\":\"123123123\"}");


        RestAssured.given().header("Content-type", "application/json")
                .and()
                .body(jsonObject.toString())
                .when().post(URL + "api/user/add")
                .then().assertThat()
                .statusCode(200);

        RestAssured.given().body(jsonObject.toString())
                .when().post(URL + "api/user/add")
                .then().assertThat()
                .statusCode(415);
    }

    @Test
    public void getByLogin() throws JSONException {
        JSONObject jsonObject = new JSONObject(
                "{\"accessLevel\":\"CLIENT\"," +
                "\"login\":\"login6\"," +
                "\"address\":\"addres5\"," + "\"pesel\":\"123123123\"}");

        RestAssured.given().header("Content-type", "application/json")
                .and()
                .body(jsonObject.toString())
                .when().post(URL + "api/user/add")
                .then().assertThat()
                .statusCode(200);

        RestAssured.given().when()
                .get(URL + "api/user/login/login5")
                .then().assertThat().statusCode(200);
    }

}
