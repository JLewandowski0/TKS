import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class BookControllerTest implements SpringTest{
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
    void addBook() {
        io.restassured.response.Response response = doGetRequest(URL + "api/book/all");
        List<String> jsonResponse = response.jsonPath().getList("$");
        int size = jsonResponse.size();

        RestAssured.given()
                .param("title","test")
                .param("author","test")
                .param("releaseDate", "2020-12-12")
                .when().post(URL + "api/book/add")
                .then().assertThat()
                .statusCode(200);



        RestAssured.given().get(URL + "api/book/all")
                .then().assertThat()
                .statusCode(200).body("size()", is(size + 1));

    }
    @Test
    void getBook() {
        io.restassured.response.Response response = doGetRequest(URL + "api/book/all");
        List<String> jsonResponse = response.jsonPath().getList("$");
        int size = jsonResponse.size();


        RestAssured.given()
                .get(URL + "api/book/all")
                .then().assertThat()
                .statusCode(200).body("size()", is(size));

    }

}
