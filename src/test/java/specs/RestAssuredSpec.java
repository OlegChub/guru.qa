package specs;


import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

public class RestAssuredSpec {
    static public RequestSpecification requestSpecification =
            with()
                    .baseUri("https://demoqa.com")
                    .contentType(ContentType.JSON)
                    .filter(customLogFilter().withCustomTemplates())
                    .log().all();
}
