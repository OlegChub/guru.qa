package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class BookStoreApiTests {
    String isbn = "9781449325862";
    Map<String, String> data = new HashMap<String, String>() {{
        put("userName", "alex");
        put("password", "asdsad#frew_DFS2");
    }};

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://demoqa.com";
    }


    @Test
    @DisplayName("Get books list")
    void getBooksList() {
        given()
                .when()
                .log().all()
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .body("books", notNullValue())
                .log().all();
    }

    @Test
    @DisplayName("Get book")
    void getOneBook() {
        given()
                .when()
                .log().all()
                .get("/BookStore/v1/Book?ISBN=" + isbn)
                .then()
                .statusCode(200)
                .body("isbn", is(isbn),
                        "title", is("Git Pocket Guide"),
                        "author", is("Richard E. Silverman"))
                .log().all();
    }

    @Test
    @DisplayName("Generate user token")
    void generateToken() {
        given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .body("status", is("Success"),
                        "result", is("User authorized successfully."))
                .log().all();
    }

    @Test
    @DisplayName("Authorize user")
    void authorizeUser() {
        given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/Account/v1/Authorized")
                .then()
                .statusCode(200)
                .log().all();
    }


}
