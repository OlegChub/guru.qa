package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static specs.RestAssuredSpec.requestSpecification;

public class BookStoreApiTests {
    String isbn = "9781449325862";
    Map<String, String> data = new HashMap<String, String>() {{
        put("userName", "alex");
        put("password", "asdsad#frew_DFS2");
    }};

    @Test
    @DisplayName("Get books list")
    void getBooksList() {
        given(requestSpecification)
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .body("books", notNullValue())
                .log().body();
    }

    @Test
    @DisplayName("Get book")
    void getOneBook() {
        given(requestSpecification)
                .get("/BookStore/v1/Book?ISBN=" + isbn)
                .then()
                .statusCode(200)
                .body("isbn", is(isbn),
                        "title", is("Git Pocket Guide"),
                        "author", is("Richard E. Silverman"))
                .log().body();
    }

    @Test
    @DisplayName("Generate user token")
    void generateToken() {
        given(requestSpecification)
                .body(data)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .body("status", is("Success"),
                        "result", is("User authorized successfully."))
                .log().body();
    }

    @Test
    @DisplayName("Authorize user")
    void authorizeUser() {
        given(requestSpecification)
                .body(data)
                .when()
                .post("/Account/v1/Authorized")
                .then()
                .statusCode(200)
                .log().body();
    }


}
