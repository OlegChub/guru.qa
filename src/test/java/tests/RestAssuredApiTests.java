package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredApiTests {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }


    @Test
    @DisplayName("Get list")
    void getList() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data.id", hasSize(6));
    }


    @Test
    @DisplayName("Create user")
    void createUser() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "Neo");
        data.put("job", "Selected");

        given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", is("Neo"))
                .body("job", is("Selected"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }


    @Test
    @DisplayName("Delete user")
    void deleteUser() {
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }

    @Test
    @DisplayName("Register user successfully")
    void RegisterSuccessfully() {
        Map<String, String> data = new HashMap<>();
        data.put("email", "eve.holt@reqres.in");
        data.put("password", "cityslicka");

        given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }


    @Test
    @DisplayName("Login user successfully")
    void LoginSuccessfully() {
        Map<String, String> data = new HashMap<>();
        data.put("email", "eve.holt@reqres.in");
        data.put("password", "cityslicka");

        given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

}
