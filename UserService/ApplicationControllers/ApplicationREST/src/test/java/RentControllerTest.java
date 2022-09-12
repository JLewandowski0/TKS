import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class RentControllerTest implements SpringTest {
    @LocalServerPort
    private int port;

    private String URL;

    public static io.restassured.response.Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    @PostConstruct
    private void init() {
        URL = BASE_URL + port + "/";
    }

    @Test
    void getRent() {
        io.restassured.response.Response response = doGetRequest(URL + "api/rent/all");
        List<String> jsonResponse = response.jsonPath().getList("$");
        int size = jsonResponse.size();

        RestAssured.given()
                .when().get(URL + "api/rent/all")
                .then()
                .assertThat()
                .statusCode(200).body("size()", is(size));
    }

    @Test
    void addRent() throws JSONException {
        io.restassured.response.Response response = doGetRequest(URL + "api/rent/all");
        List<String> jsonResponse = response.jsonPath().getList("$");
        int size = jsonResponse.size();

        JSONObject jsonObject = new JSONObject(
                "{\"startDate\":\"2020-12-12\"," +
                        "\"client\":\"login5\"," +
                        "\"address\":\"addres5\"," + "\"pesel\":\"123123123\"}");

    }
}
