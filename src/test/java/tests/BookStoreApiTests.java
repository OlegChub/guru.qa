package tests;


import helper.LombokBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RestAssuredSpec.requestSpecification;
import static specs.RestAssuredSpec.resSpec;

public class BookStoreApiTests {
    String isbn = "9781449325862";
    String title = "Git Pocket Guide";
    String author = "Richard E. Silverman";
    String date = "2020-06-04T08:48:39.000Z";
    Integer pageCount = 234;


    @Test
    @DisplayName("Get book")
    void getOneBook() {
        given(requestSpecification)
                .get("/BookStore/v1/Book?ISBN=" + isbn)
                .then()
                .statusCode(200)
                .body("isbn", is(isbn),
                        "title", is(title),
                        "author", is(author))
                .log().body();
    }

    @Test
    @DisplayName("Check book fields with lombok help")
    void checkBookFieldsWithLombok() {
        LombokBook data =
                given(requestSpecification)
                        .get("/BookStore/v1/Book?ISBN=" + isbn)
                        .then()
                        .statusCode(200)
                        .extract().as(LombokBook.class);

        assertEquals(isbn, data.getIsbn());
        assertEquals(title, data.getTitle());
        assertEquals(author, data.getAuthor());
        assertEquals(pageCount, data.getPages());
        assertEquals(date, data.getPublishDate());
    }

    @Test
    @DisplayName("Check website is present with Groovy filter in books list")
    void checkWebSiteWithGroovyInBooksList() {
        given(requestSpecification)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(resSpec)
                .body("books.findAll{it.website}.website.flatten()",
                        hasItem("http://speakingjs.com/"));
    }

    @Test
    @DisplayName("Check isbn quantity with Groovy filter in books list")
    void countIsbnWithGroovyInBooksList() {
        given(requestSpecification)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(resSpec)
                .body("books.findAll{it.isbn}.size()",
                        is(8));
    }

}
